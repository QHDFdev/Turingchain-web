package com.tulingchain.service.impl.bill;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.mapper.billMapper.IssuanceMapper;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.model.bill.Issuance;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.restful.api.RestWriteClient;
import com.tulingchain.service.bill.BillNoderService;
import com.tulingchain.utils.SpringUtils;

@Service
public class BillNoderServiceImpl implements BillNoderService {
	
	@Autowired
	public IssuanceMapper issuanceMapper;
	
	@Autowired
	public BillNoderMapper billNoderMapper;
	
	
	@Override
	public JSONArray queryMyBills(String pubk) {
		JSONArray array=null;
		try {
			ReadClient client=new ReadClient();
			array=client.queryMyBills(pubk);
			
		} catch (IOException e) {
		}
		return array;
	}

	@Override
	public JSONObject testApi(JSONObject bill) {
		JSONObject obj=null;
		try {
			obj=RestWriteClient.testApi(bill);
		} catch (IOException e) {
		}
		return obj;
	}

	
	/*
	 * 操作步骤：
	 * 1.根据id 从api获得bill JSONObject ，如果没有此bill ，则返回查无此签发
	 * 2.获得origin_pubk,origin_private_prik,,pre_id,createId
	 * 3.确认承贴
	 * 
	 * (non-Javadoc)
	 * @see com.tulingchain.service.bill.BillNoderService#EnsureDiscounting(java.lang.String)
	 */
	@Override
	public JSONObject ensureDiscounting(String id) {
		Issuance issuance= issuanceMapper.selectIssuanceByCreateId(id);;
		issuance.setIsDiscounted(2);
		Runnable quietTransfer=new QuietTransfer(id);
		Thread thread=new Thread(quietTransfer);
		thread.start();
		issuanceMapper.updateDiscounted(issuance);
		JSONObject re=new JSONObject();
		re.put("state", 2);
		return re;
	}
}

//金融机构承贴确认
class QuietTransfer implements Runnable{	
	private String id;
	private boolean flag=true;
	JSONObject transfer=null;
	
	public IssuanceMapper issuanceMapper=(IssuanceMapper) SpringUtils.getBeanByClass(IssuanceMapper.class);;
	
	public BillNoderMapper billNoderMapper=(BillNoderMapper) SpringUtils.getBeanByClass(BillNoderMapper.class);;
	QuietTransfer(String id){
		this.id=id;
	}
	
	
	@Override
	public void run() {
		ReadClient readClient=null;
		try {
			readClient=new ReadClient();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject obj=null;
		Issuance issuance=null;
		JSONObject object=null;
		try {
			ReadClient client=new ReadClient();
			JSONObject bill=client.getTransactionByid(id);
			
			obj=bill.getJSONObject("transaction").getJSONObject("data").getJSONObject("payload").getJSONObject("bill");
			System.out.println("obj++++++++++++++++"+obj);
			 issuance=issuanceMapper.selectIssuanceByCreateId(id);
			int origin=issuance.getSigner();
			int receive=issuance.getPayee();
			BillNoder originNoder=billNoderMapper.getNoderById(origin);
			BillNoder reveiveNoder=billNoderMapper.getNoderById(receive);
			String receivePubkey=reveiveNoder.getNodePubKey()==null?null:reveiveNoder.getNodePubKey();
			String receivePrikey=reveiveNoder.getNodePrivateKey()==null?null:reveiveNoder.getNodePrivateKey();
			// make sure to discount
			transfer=RestWriteClient.transferBillTransaction(originNoder.getNodePubKey(), originNoder.getNodePrivateKey(),receivePubkey, id, obj);
			System.out.println(transfer);
			
			while(flag){
				System.out.println("=================");
					try {
						Thread.sleep(3000);
						object = client.getTransactionByid(transfer.getString("txid"));
						if (!object.containsKey("error")) {
							flag = false;
						}
					} catch (Exception e) {
					}
			}
			//如果接收用户没有公私钥赋值给他们
			if(receivePubkey==null && receivePrikey==null){
				receivePubkey=transfer.getString("receive_pubk");
				receivePrikey=transfer.getString("receive_prik");
				BillNoder billNoder1=new BillNoder();
				billNoder1.setCompanyName(reveiveNoder.getCompanyName());
				billNoder1.setNodePubKey(receivePubkey);
				billNoder1.setNodePrivateKey(receivePrikey);
				billNoderMapper.updatePubKPriK(billNoder1);
			}
			
		} catch (IOException e) {
			issuance.setIsDiscounted(0);
			issuanceMapper.updateDiscounted(issuance);
		}
		issuance.setIsDiscounted(1);
		issuance.setTransferId(transfer.getString("txid"));
		issuanceMapper.updateDiscounted(issuance);
		issuanceMapper.updateCreateThrnsferId(issuance);
	}
	
}