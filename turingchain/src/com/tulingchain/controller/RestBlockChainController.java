package com.tulingchain.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tulingchain.model.Page;
import com.tulingchain.restful.api.ReadClient;
import com.tulingchain.utils.JsonUtils;
import com.tulingchain.utils.PageNavUtils;
/**
 * 
 * 前台通过访问这些方法来获得相应的JSON数据
 * @author Soooooolazy
 *
 */

@Controller
public class RestBlockChainController {
	
	@RequestMapping(value = "/getKeyPairRest", method = RequestMethod.GET)
	public @ResponseBody String getKeyPair() throws IOException {
		ReadClient client=null;
		JSONObject keyPair=null;
		try {
			 client = new ReadClient();
			 keyPair = client.getKeyPair();
		} catch (Exception e) {
			client.close();
		}finally{
			client.close();
		}
		return keyPair.toJSONString();
	}
	
	
	@RequestMapping(value = "/getBlockByIdRest/{id}", method = RequestMethod.GET)
	public @ResponseBody String getKeyPair(@PathVariable String id) throws IOException {
		ReadClient client = new ReadClient();
		JSONObject block=client.getBlockById(id);
		client.close();
		return block.toJSONString();
	}
	
	
	@RequestMapping(value = "/getBlockByHeightRest/{height}", method = RequestMethod.GET)
	public @ResponseBody String getBlockByHeight(
			@PathVariable("height") int height) throws ClientProtocolException, IOException {
		ReadClient client = new ReadClient();
		JSONObject bigBlock = client.getBlockByHeight(height);
		client.close();
		return bigBlock.toJSONString();
	}
	
	@RequestMapping(value="/getLastTransactionRest",method=RequestMethod.GET)
	public @ResponseBody String getLastTransaction() throws ClientProtocolException, IOException{
		ReadClient client=new ReadClient();
		JSONObject lastTran=client.getLastTransaction();
		client.close();
		return lastTran.toJSONString();
	}
	
	@RequestMapping(value="/getLastBlockRest",method=RequestMethod.GET)
	public @ResponseBody String getLastBlock() throws ClientProtocolException, IOException{
		JSONObject lastBlock=ReadClient.getLastBlock();
		return lastBlock.toJSONString();
	}
	
	@RequestMapping(value="/getTransactionByidRest/{tid}",method=RequestMethod.GET)
	public @ResponseBody String getTransactionByid(@PathVariable String tid) throws ClientProtocolException, IOException{
		ReadClient client=new ReadClient();
		JSONObject transaction=client.getTransactionByid(tid);
//		String str=JsonUtils.unicode2String(transaction.toJSONString());
		client.close();
		return transaction.toJSONString();
	}
	
	/*
	 * 首页获取区块信息
	 */
	@RequestMapping(value="/getListBlockRest",method=RequestMethod.GET)
	public @ResponseBody String getListBlock() throws ClientProtocolException, IOException{
		ReadClient client=null;
		String listBlock=null;
		try {
			client=new ReadClient();
			listBlock=client.getListBlock(5);
		} catch (Exception e) {
			client.close();
		}
		return listBlock;
	}
	

	
	/*
	 * 首页获取交易信息 
	 */
	@RequestMapping(value="/getListTransRest",method=RequestMethod.GET)
	public @ResponseBody String getListTrans() throws ClientProtocolException, IOException{
		ReadClient client=null;
		String listTrans=null;
		
		try {
			client=new ReadClient();
//			listTrans=client.getListTrans(10);
			listTrans=client.getListTransfer(5);
		} catch (Exception e) {
			client.close();
		}finally{
			client.close();
		}
		
		return listTrans;
	}
	
	/**
	 * 
	 * 前台传过来 currentPage 和  listNumPerPage，在业务层写一个业务 ,Page getCurrentPage(int currentPageNum,int listNumPerPage)
	 * 
	 * 直接返回一个Page对象，里面有各种属性，
	 * 可以实现 动态选择每页显示多少条效果
	 * 
	 * @return List<BigBlock>
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * 
	 */
	@RequestMapping(value="/queryBlocksRest/{currentPage}/{listNumPerPage}",method=RequestMethod.GET)
	public @ResponseBody Page getCurrentPage(@PathVariable int currentPage,@PathVariable int listNumPerPage ) throws ClientProtocolException, IOException{
		
		ReadClient client = new ReadClient();
		
		//得到一个page 对象
		Page page=new Page();
		//由于区块高度有序号为0的区块,所以总条目的区块高度+1
		int count=client.getLastBlockHeight();
		//得到区块高度，由于现在区块不可删，且是从soap出得到，暂且认为数据库高度就是数据条目
		page.setCount(count);
		//设置当前页码
		page.setCurrentPage(currentPage);
		//设置每页显示条目
		page.setListNumPerPage(listNumPerPage);
		//设置总共多少页
		page.setTotalPages(PageNavUtils.getTotalPages(count, listNumPerPage));
		
		
		//得到每页第一条数据的序号
		int currentPageFirstNum=PageNavUtils.getCurrentPageFirstNum2(currentPage, listNumPerPage);
		System.out.println("====================="+currentPageFirstNum);
		//开始根据id查询区块
		List<JSONObject> listBlocks=new ArrayList<JSONObject>();
		for(int i=currentPageFirstNum;i<currentPageFirstNum+listNumPerPage;i++){
			JSONObject jsonObject = client.getBlockByHeight(i);
			if(jsonObject==null){
				i++;
				continue;
			}
			listBlocks.add(jsonObject);
		}
		//将block信息放入page对象
		page.setListPerPage(listBlocks);
		return page;
	}
	
	
	
	@RequestMapping(value="/getBlockContent/{height}/{hash}",method=RequestMethod.GET)
	public @ResponseBody String getBlockContent(@PathVariable int height,@PathVariable String hash) throws ClientProtocolException, IOException{
		ReadClient client=new ReadClient();
		JSONObject object=client.getBlockContent(height, hash);
		return object.toJSONString();
	}
	
	
	/*
	 *  前端溯源系统
	 */
	@RequestMapping(value="/getAllTrace/{tid}",method=RequestMethod.GET)
	public @ResponseBody String getAllPrevious(@PathVariable String tid) throws ClientProtocolException, IOException{
		ReadClient client=new ReadClient();
		byte[] str=client.getAllPrevious(tid).replace("\\\\", "\\").getBytes("utf-8");
		String str1=JsonUtils.ascii2native(new String(str,"utf-8"));
		System.out.println("======"+str);
		System.out.println("======"+str1);
		
		return str1;
	
		//return str;
	}
}
