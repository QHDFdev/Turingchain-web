package com.tulingchain.soap.rpc;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.tulingchain.soap.schema.read.Application;
import com.tulingchain.soap.schema.read.BigBlock;
import com.tulingchain.soap.schema.read.Data;
import com.tulingchain.soap.schema.read.KeyPair;
import com.tulingchain.soap.schema.read.LastBlock;
import com.tulingchain.soap.schema.read.LastTx;
import com.tulingchain.soap.schema.read.StringArray;
import com.tulingchain.soap.schema.read.TransactionArray;

public class ReadClient {
	
	private Application app;
	private static final String WSDL_URL = "http://120.27.158.8:8000/rpc/wsdl/";

	public ReadClient() {
		try {
			Service service = Service.create(new URL(WSDL_URL), new QName(Utils.SERVICE_QNAME, "RpcService"));
			app = service.getPort(new QName(Utils.SERVICE_QNAME, "Application"), Application.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LastBlock getLastBlock() {
		return app.getLastBlock();
	}
	
	public LastTx getLastTx() {
		return app.getLastTx();
	}
	
	public BigBlock getBlockByHeight(int height) {
		return app.getBlockByHeight(BigInteger.valueOf(height));
	}
	
	public BigBlock getBlockByTxId(String txId) {
		return app.getBlockByTxId(txId);
	}
	
	public Integer getBlockHeightByTxId(String txId) {
		BigInteger height = app.getBlockHeightByTxId(txId);
		return height.intValue();
	}
	
	public Data getTxById(String id) {
		return app.getTxById(id);
	}
	
	public TransactionArray getTxsByBlockAddr(String addr) {
		return app.getTxsByBlockAddr(addr);
	}
	
	public KeyPair getKeyPair() {
		return app.getKeyPair();
	}
	
	public StringArray traceTransactions(String publicKey) {
		return app.traceTransactions(publicKey);
	}
	
}
