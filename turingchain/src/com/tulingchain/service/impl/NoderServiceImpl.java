package com.tulingchain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.ApplyMapper;
import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.UserMapper;
import com.tulingchain.mapper.billMapper.BillNoderMapper;
import com.tulingchain.model.Apply;
import com.tulingchain.model.Noder;
import com.tulingchain.model.User;
import com.tulingchain.model.bill.BillNoder;
import com.tulingchain.service.NoderService;
import com.tulingchain.utils.MailUitls;
import com.tulingchain.utils.UUIDUtils;

@Service("noderService")
public class NoderServiceImpl implements NoderService {

	@Autowired
	private UserMapper userMapper;
	
	
	
	@Autowired
	private ApplyMapper applyMapper;
	
	@Autowired
	private NoderMapper noderMapper;
	
	@Autowired
	private BillNoderMapper billNoderMapper;
	
	
	@Override
	public void addNoder(Noder noder) {
		noder.setRegisterStart(new Date());
		noder.setNoderState("未审核");
		noderMapper.save(noder);
	}
	
	//BillNoder
	@Override
	public void addBillNoder(BillNoder billNoder) {
		billNoder.setRegisterStart(new Date());
		String uuid=UUIDUtils.getUUID();
		billNoder.setNoderKey(uuid);
		billNoder.setNoderState(0);// 0 表示未审核 1 表示审核通过
//		try {
//			String pubkey=RestWriteClient.getKeyPair().getString("public_key");
//			String prikey=RestWriteClient.getKeyPair().getString("private_key");
//			billNoder.setNodePubKey(pubkey);
//			billNoder.setNodePrivateKey(prikey);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		billNoderMapper.save(billNoder);
		MailUitls.sendMail(billNoder.getEmail(),"您的授权码是"+uuid);
		
	}
	
	
	/*
	 * 	普通用户升级成节点用户
	 * @see com.tulingchain.service.NoderService#upGrade(com.tulingchain.model.Noder)
	 */
		@Override
		public void upGrade(Noder noder) {
			//节点秘钥
			String code = UUIDUtils.getUUID();
			noder.setNoderKey(code);
			noder.setRegisterStart(new Date());
			noder.setNoderState("审核通过");
			String userName=noder.getNoderName();
			//传递user信息
			User user=userMapper.getByName(userName);
			noder.setEmail(user.getEmail());
			noder.setPassword(user.getPassword());
			//传递apply信息
			Apply apply=applyMapper.getByName(userName);
			noder.setNoderType(apply.getApplyType());
			noderMapper.save(noder);
			System.out.println(userName);
			// 发送邮件
			MailUitls.sendMail(noder.getEmail(), code);
					
			applyMapper.deleteByName(userName);
			userMapper.deleteByName(userName);
		}

	@Override
	public void delete(Integer id) {
		noderMapper.delete(id);
	}
	
	@Override
	public void deleteBill(Integer id) { //BillNoder
		billNoderMapper.delete(id);
	}
	
	@Override
	public List<Noder> listAll() {
		return noderMapper.listAll();
	}
	
	@Override
	public List<BillNoder> listAllBill() {
		return billNoderMapper.listAll(); //BillNoder
	}
	
	@Override
	public List<Noder> listAllByState() {
		return noderMapper.listAllByState();
	}

	@Override
	public Noder findNoderByName(String noderName) {
		return noderMapper.getNoderByName(noderName);
	}
	
	@Override						//BillNoder
	public BillNoder findBillNoderByName(String noderName) {
		return billNoderMapper.getNoderByName(noderName);
	}

	@Override
	public Noder findNoderById(int id) {
		return noderMapper.getNoderById(id);
	}
	
	@Override
	public Noder findNoderByEmail(String email) {
		return noderMapper.getNoderByEmail(email);
	}
	
	@Override
	public BillNoder findBillNoderByEmail(String email) {  //BillNoder
		return billNoderMapper.getNoderByEmail(email);
	}

	@Override
	public Noder queryLogin(Noder noder) {
		return noderMapper.queryLogin(noder);
	}
	
	@Override
	public BillNoder queryLogin(BillNoder noder) {  //BillNoder登陆
		
		return billNoderMapper.queryLogin(noder);
	}
	
	@Override
	public Noder findByComNum(String comNum) {
		return noderMapper.getNoderByComNum(comNum);
	}
	
	
	@Override
	public BillNoder findBillByComNum(String comNum) {
		return billNoderMapper.getNoderByComNum(comNum);//BillNoder
	}

	@Override
	public Noder findByComName(String comName) {
		return noderMapper.getNoderByComName(comName);
	}
	
	@Override
	public BillNoder findBillByComName(String comName) {//BillNoder
		return billNoderMapper.getNoderByComName(comName);
	}

	@Override
	public String passNoder(Noder noder) {
		
		String noderKey = UUIDUtils.getUUID();
		noder.setNoderState("审核通过");
		noder.setNoderKey(noderKey);
		//发送邮件
		MailUitls.sendMail(noder.getEmail(), noderKey);
		if(noderMapper.updateState(noder) == 1){
			return "成功";
		}
		return "失败";
	}

	@Override
	public String failNoder(Noder noder) {
		noder.setNoderState("审核未通过");
		//发送邮件
		MailUitls.sendMail(noder.getEmail(), "您没有通过审核！");
		if(noderMapper.updateState(noder) == 1){
			return "成功";
		}
		return "失败";
	}

	@Override
	public List<Noder> listAllByState2() {
		return noderMapper.listAllByState2();
	}

	@Override
		public String deleteNoder(Noder noder) {
			
			if(noderMapper.deleteNoder(noder) == 1){
				return "成功";
			}
			return "失败";
		}

	@Override
	public Noder queryNoderServer(int id) {
		return noderMapper.getNoderSer(id);
	}

	@Override
	public String queryNoderIpServer(int id) {
		return noderMapper.getNoderIpSer(id);
	}

	@Override
	public String queryNoderPubKeyServer(int id) {
		return noderMapper.getNoderPubKeySer(id);
	}

	@Override
	public Date queryNoderRegDateServer(int id) {
		return noderMapper.getNoderRegDateSer(id);
	}

	@Override
	public String queryNoderRegUserCountServer(int id) {
		return noderMapper.getNoderRegUserCountSer(id);
	}

	@Override
	public void upNoderImg(Noder noder) {
		noderMapper.updateImg(noder);
	}

	@Override
	public void updatePwd(String noderName, String newPassword) {
		noderMapper.updatePwd(noderName,newPassword);
	}


}
