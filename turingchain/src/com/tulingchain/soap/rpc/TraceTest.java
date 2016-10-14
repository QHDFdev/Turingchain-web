package com.tulingchain.soap.rpc;

import com.tulingchain.soap.schema.read.KeyPair;
import com.tulingchain.soap.schema.read.StringArray;
import com.tulingchain.soap.schema.write.Thing;
import com.tulingchain.soap.schema.write.TransferResult;
import com.tulingchain.soap.schema.write.When;
import com.tulingchain.soap.schema.write.Where;
import com.tulingchain.soap.schema.write.WhereItem;
import com.tulingchain.soap.schema.write.Who;
import com.tulingchain.soap.schema.write.WhoItem;

public class TraceTest {

	public static void main(String[] args) {
		ReadClient readClient = new ReadClient();
		WriteClient writeClient = new WriteClient();
		//Í¼Áé -> Ë³·á
		WhoItem whoGoto = Utils.generateWhoItem("000001", "Í¼Áé", "000001", "000001", "ÀîÀ×", "3");
		WhoItem whoOriginal = new WhoItem();
		Who who = Utils.generateWho(whoOriginal, whoGoto);
		WhereItem whereGoto = Utils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
		WhereItem whereOriginal = new WhereItem();
		Where where = Utils.generateWhere(whereOriginal, whereGoto);
		KeyPair txOriginatorKeyPair = readClient.getKeyPair();
		KeyPair txRecipientKeyPair = readClient.getKeyPair();
		When when = Utils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		Thing thing = Utils.generateThing("1", "ÀàÐÍ", "1", "²£Á§", "shenzhen", "100", "1", "12");
		String txId = writeClient.createTransaction(txOriginatorKeyPair.getPublicKey().getValue(), who, where, when, thing);
		System.out.println("Create transaction id: " + txId);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		whoOriginal = Utils.generateWhoItem("000002", "Ë³·á", "000002", "000002", "º«Ã·Ã·", "4");
		whereOriginal = Utils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
		who = Utils.generateWho(whoGoto, whoOriginal);
		where = Utils.generateWhere(whereGoto, whereOriginal);
		thing = Utils.generateThing("1", "ÀàÐÍ", "1", "²£Á§", "shenzhen", "10", "1", "12");
		TransferResult result = writeClient.transferTransaction(txOriginatorKeyPair.getPublicKey().getValue(), txRecipientKeyPair.getPublicKey().getValue(), txOriginatorKeyPair.getPrivateKey().getValue(), who, where, when, thing);
		if (!result.getMessage().getValue().equals("OK")) {
			System.out.println(result.getMessage().getValue());
			return;
		} else {
			System.out.println("Transfer transaction id: " + result.getTxs().getValue().getTransferId().getValue());
		}
		if (result.getTxs().getValue().getCreateId() != null) {
			System.out.println("Create transaction id: " + result.getTxs().getValue().getCreateId().getValue());
			System.out.println("Private key: " + result.getNewKeyPair().getValue().getPrivateKey().getValue());
			System.out.println("Public key: " + result.getNewKeyPair().getValue().getPublicKey().getValue());
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ë³·á -> ¿Í»§
		KeyPair customerKeyPair = readClient.getKeyPair();
		whoOriginal = Utils.generateWhoItem("000002", "Ë³·á", "000002", "000002", "º«Ã·Ã·", "4");
		whereOriginal = Utils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
		whoGoto = Utils.generateWhoItem("0", "²âÊÔ", "000", "00000", "ÖÜ", "1");
		whereGoto = Utils.generateWhereItem("china", "nanjing", "jiangsu", "025");
		who = Utils.generateWho(whoOriginal, whoGoto);
		where = Utils.generateWhere(whereOriginal, whereGoto);
		result = writeClient.transferTransaction(txRecipientKeyPair.getPublicKey().getValue(), customerKeyPair.getPublicKey().getValue(), txRecipientKeyPair.getPrivateKey().getValue(), who, where, when, thing);
		if (!result.getMessage().getValue().equals("OK")) {
			System.out.println(result.getMessage().getValue());
			return;
		} else {
			System.out.println("Transfer transaction id: " + result.getTxs().getValue().getTransferId().getValue());
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringArray txs = readClient.traceTransactions(customerKeyPair.getPublicKey().getValue());
		System.out.println("Trace transactions: " + txs.getString().size());
		for (String temp: txs.getString()) {
			System.out.println(temp);
		}
	}
	
}
