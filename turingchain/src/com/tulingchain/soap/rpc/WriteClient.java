package com.tulingchain.soap.rpc;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.alibaba.fastjson.JSONObject;
import com.tulingchain.soap.schema.write.Application;
import com.tulingchain.soap.schema.write.Thing;
import com.tulingchain.soap.schema.write.TransferResult;
import com.tulingchain.soap.schema.write.When;
import com.tulingchain.soap.schema.write.Where;
import com.tulingchain.soap.schema.write.Who;

public class WriteClient {
	
	private Application app;
	private static final String WSDL_URL = "http://120.27.158.8:8000/rpc/wsdl/";
	
	public WriteClient() {
		try {
			Service service = Service.create(new URL(WSDL_URL), new QName(Utils.SERVICE_QNAME, "RpcService"));
			app = service.getPort(new QName(Utils.SERVICE_QNAME, "Application"), Application.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String createTransaction(String publicKey, Who who, Where where, When when, Thing thing) {
		return app.createTransaction(publicKey, who, where, when, thing);
	}
	
	public TransferResult transferTransaction(String txOriginatorPublicKey, String txRecipientPublicKey, String txOriginatorPrivateKey, Who who, Where where, When when, Thing thing) {
		return app.transferTransaction(txOriginatorPublicKey, txRecipientPublicKey, txOriginatorPrivateKey, who, where, when, thing);
	}

	
	
}
