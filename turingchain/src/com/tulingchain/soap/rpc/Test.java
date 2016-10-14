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

public class Test {

	public static void main(String[] args) {
		ReadClient readClient = new ReadClient();
		WriteClient writeClient = new WriteClient();
//		test get data
		System.out.println("Block number: " + readClient.getLastBlock().getHeight().getValue());
		
		//System.out.println(readClient.getBlockHeightByTxId("a162a6d46b7c341a28d0475d21cbab716f92ab0b08f020f8b45695fd3ea870a4"));
		//System.out.println(readClient.getBlockByTxId("a162a6d46b7c341a28d0475d21cbab716f92ab0b08f020f8b45695fd3ea870a4").getBlock().getValue().getNodePubkey().getValue());
/*//		test create transaction
		WhoItem whoGoto = Utils.generateWhoItem("000001", "ͼ��", "000001", "000001", "����", "3");
		WhoItem whoOriginal = new WhoItem();
		Who who = Utils.generateWho(whoOriginal, whoGoto);
		WhereItem whereGoto = Utils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
		WhereItem whereOriginal = new WhereItem();
		Where where = Utils.generateWhere(whereOriginal, whereGoto);
		KeyPair txOriginatorKeyPair = readClient.getKeyPair();
		KeyPair txRecipientKeyPair = readClient.getKeyPair();
		When when = Utils.generateWhen("1470209585", "1470209585", "1470209585", "1470209585");
		Thing thing = Utils.generateThing("1", "����", "1", "��Ʒ", "shenzhen", "100", "1", "12");
		String txId = writeClient.createTransaction(txOriginatorKeyPair.getPublicKey().getValue(), who, where, when, thing);
		System.out.println("Create transaction id: " + txId);
//		test transfer transaction
//		wait till the create transaction is done
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		whoOriginal = Utils.generateWhoItem("000002", "˳��", "000002", "000002", "��÷÷", "4");
		whereOriginal = Utils.generateWhereItem("china", "shenzhen", "guangdong", "0755");
		who = Utils.generateWho(whoGoto, whoOriginal);
		where = Utils.generateWhere(whereGoto, whereOriginal);
		thing = Utils.generateThing("1", "����", "1", "��Ʒ", "shenzhen", "90", "1", "12");
		TransferResult result = writeClient.transferTransaction(txOriginatorKeyPair.getPublicKey().getValue(), txRecipientKeyPair.getPublicKey().getValue(), txOriginatorKeyPair.getPrivateKey().getValue(), who, where, when, thing);
		System.out.println("Transfer transaction id: " + result.getTxs().getValue().getTransferId().getValue());
		if (result.getTxs().getValue().getCreateId() != null) {
			System.out.println("Create transaction id: " + result.getTxs().getValue().getCreateId().getValue());
			System.out.println("Private key: " + result.getNewKeyPair().getValue().getPrivateKey().getValue());
			System.out.println("Public key: " + result.getNewKeyPair().getValue().getPublicKey().getValue());
//			wait till the transactions are done
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringArray txs = readClient.traceTransactions(result.getNewKeyPair().getValue().getPublicKey().getValue());
			System.out.println("Trace transactions: " + txs.getString().size());
			for (String temp: txs.getString()) {
				System.out.println(temp);
			}
		}
		String username = readClient.getTxById(txId).getPayload().getValue().getWho().getValue().getGoto().getValue().getUserName().getValue();
		System.out.println(Utils.UnicodeToChinese(username));*/
	}
	
}
