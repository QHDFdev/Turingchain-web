package com.tulingchain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulingchain.model.Page;
import com.tulingchain.soap.rpc.ReadClient;
import com.tulingchain.soap.rpc.Utils;
import com.tulingchain.soap.schema.read.BigBlock;
import com.tulingchain.soap.schema.read.Data;
import com.tulingchain.soap.schema.read.KeyPair;
import com.tulingchain.soap.schema.read.LastBlock;
import com.tulingchain.soap.schema.read.LastTx;
import com.tulingchain.soap.schema.read.Transaction;
import com.tulingchain.soap.schema.read.TransactionArray;
import com.tulingchain.utils.PageNavUtils;

@Controller
public class BlockChainController {

	@RequestMapping(value = "/getBlockByHeight/{height}", method = RequestMethod.GET)
	public @ResponseBody BigBlock getBlockByHeight(
			@PathVariable("height") int height) {
		ReadClient client = new ReadClient();
		BigBlock bigBlock = client.getBlockByHeight(height);
		return bigBlock;
	}

	@RequestMapping(value = "/getLastBlock", method = RequestMethod.GET)
	public @ResponseBody LastBlock getLastBlock() throws Exception {
		ReadClient client = new ReadClient();
		LastBlock lastBlock = client.getLastBlock();
		return lastBlock;
	}

	@RequestMapping(value = "/getLastTx", method = RequestMethod.GET)
	public @ResponseBody LastTx getLastTx() {
		ReadClient client = new ReadClient();
		LastTx lastTx = client.getLastTx();
		return lastTx;
	}

	@RequestMapping(value = "/getTxsByBlockAddr/{addr}", method = RequestMethod.GET)
	public @ResponseBody TransactionArray getTxsByBlockAddr(
			@PathVariable("addr") String addr) {
		ReadClient client = new ReadClient();
		TransactionArray transactionArray = client.getTxsByBlockAddr(addr);
		return transactionArray;
	}

	@RequestMapping(value = "/getTxById/{id}", method = RequestMethod.GET)
	public @ResponseBody Data getTxById(@PathVariable("id") String id) {
		ReadClient client = new ReadClient();
		Data data = client.getTxById(id);
		
		if(data.getPayload().getValue().getWho().getValue().getOriginal().getValue().getCompanyName() != null){
			
			data.getPayload().getValue().getThing().getValue().getThingName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getThing().getValue().getThingName().getValue()));
			data.getPayload().getValue().getThing().getValue().getThingTypeName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getThing().getValue().getThingTypeName().getValue()));
			data.getPayload().getValue().getThing().getValue().getOriginPlace().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getThing().getValue().getOriginPlace().getValue()));
			
			data.getPayload().getValue().getWho().getValue().getGoto().getValue().getCompanyName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWho().getValue().getGoto().getValue().getCompanyName().getValue()));
			data.getPayload().getValue().getWho().getValue().getGoto().getValue().getUserName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWho().getValue().getGoto().getValue().getUserName().getValue()));
			data.getPayload().getValue().getWho().getValue().getOriginal().getValue().getCompanyName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWho().getValue().getOriginal().getValue().getCompanyName().getValue()));
			data.getPayload().getValue().getWho().getValue().getOriginal().getValue().getUserName().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWho().getValue().getOriginal().getValue().getUserName().getValue()));
			
			data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getNation().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getNation().getValue()));
			data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getPlace().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getPlace().getValue()));
			data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getRegion().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getGoto().getValue().getRegion().getValue()));
			
			data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getNation().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getNation().getValue()));
			data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getPlace().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getPlace().getValue()));
			data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getRegion().setValue(Utils.UnicodeToChinese(data.getPayload().getValue().getWhere().getValue().getOriginal().getValue().getRegion().getValue()));
		}
		

		return data;
	}

	@RequestMapping(value = "/getKeyPair", method = RequestMethod.GET)
	public @ResponseBody KeyPair getKeyPair() {
		ReadClient client = new ReadClient();
		KeyPair keyPair = client.getKeyPair();
		return keyPair;
	}
	

	
	
	/*
	 * AJ 中 HomeController 调用此方法获得首页5条记录
	 */
	@RequestMapping(value = "/getListBlock", method = RequestMethod.GET)
	public @ResponseBody List<BigBlock> getListBlock() {
		ReadClient client = new ReadClient();
		//获得区块高度
		int getBlockHeight = Integer.parseInt(client.getLastBlock().getHeight()
				.getValue());
		//List 用来存放所有区块
		List<BigBlock> bigBlocks = new ArrayList<BigBlock>();
		//首页只显示5条
		int k = 5;
		for (int i = getBlockHeight; i > getBlockHeight - k; i--) {
			BigBlock bigBlock = client.getBlockByHeight(i);
			if (bigBlock == null) {
				k++;
				continue;
			}
			bigBlocks.add(bigBlock);
		}
		return bigBlocks;
	}

	@RequestMapping(value = "/getListTx", method = RequestMethod.GET)
	public @ResponseBody List<Transaction> getListTx() {
		ReadClient client = new ReadClient();
		int getBlockHeight = Integer.parseInt(client.getLastBlock().getHeight()
				.getValue());
		List<Transaction> trans = new ArrayList<Transaction>();
		int k = 5;
		for (int i = getBlockHeight; i > getBlockHeight - k; i--) {
			BigBlock bigBlock = client.getBlockByHeight(i);
			if (bigBlock != null) {
				List<Transaction> list = client.getBlockByHeight(i).getBlock()
						.getValue().getTransactions().getValue()
						.getTransaction();
				if (list.size() > 0) {
					for (int j = 0; j < list.size(); j++) {
						if ("TRANSFER".equals(list.get(j).getTransaction()
								.getValue().getOperation().getValue())) {
							trans.add(list.get(j));
							if (trans.size() > 4) {
								break;
							}
						} else {
							k++;
						}
					}
				} else {
					k++;
				}

			} else {
				k++;
			}
			
			if (trans.size() > 4) {
				break;
			}
		}
		return trans;
	}
	
	
	/**
	 * 
	 * 前台传过来 currentPage 和  listNumPerPage，在业务层写一个业务 ,Page getCurrentPage(int currentPageNum,int listNumPerPage)
	 * 
	 * 直接返回一个Page对象，里面有各种属性，
	 * 可以实现 动态选择每页显示多少条效果
	 * 
	 * @return List<BigBlock>
	 * 
	 */
	@RequestMapping(value="/queryBlocks/{currentPage}/{listNumPerPage}",method=RequestMethod.GET)
	public @ResponseBody Page getCurrentPage(@PathVariable int currentPage,@PathVariable int listNumPerPage ){
		
		ReadClient client = new ReadClient();
		
		//得到一个page 对象
		Page page=new Page();
		//由于区块高度有序号为0的区块,所以总条目的区块高度+1
		int count=Integer.parseInt(client.getLastBlock().getHeight().getValue())+1;
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
		List<BigBlock> bigBlocks=new ArrayList<BigBlock>();
		
		for(int i=currentPageFirstNum;i<currentPageFirstNum+listNumPerPage;i++){
			BigBlock bigBlock = client.getBlockByHeight(i);
			System.out.println("------------------"+bigBlock);
			if(bigBlock==null){
				i++;
				continue;
			}
			bigBlocks.add(bigBlock);
		}
		
		System.out.println("++++++++++++++++++++"+bigBlocks.size());
		//将block信息放入page对象
//		page.setListPerPage(bigBlocks);
		
		return page;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int currentPageFirstNum=PageNavUtils.getCurrentPageFirstNum2(2, 20);
		System.out.println(currentPageFirstNum);
		
		ReadClient client = new ReadClient();
		int getBlockHeight = Integer.parseInt(client.getLastBlock().getHeight()
				.getValue());
		System.out.println(client.getBlockByHeight(30).getBlockNumber().getValue());          //获得区块
		System.out.println(client.getBlockByHeight(30).getBlock().getValue().getTransactions().getValue().getTransaction().get(0).getId().getValue());          //获得区块  Transaction ID
		System.out.println(client.getBlockByHeight(30).getBlock().getValue().getNodePubkey().getValue());//获得Node-PubKey
		System.out.println(client.getBlockByHeight(30).getBlock().getValue().getTimestamp().getValue());//获得时间戳
		System.out.println(getBlockHeight);
	}
}
