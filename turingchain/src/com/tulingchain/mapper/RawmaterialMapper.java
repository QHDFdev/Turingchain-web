package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.Rawmaterial;

public interface RawmaterialMapper {

	public void save(Rawmaterial rawmaterial);
	
	public List<Rawmaterial> listAll(int sellerId);

	public Rawmaterial getRawmById(int id);

	public List<Rawmaterial> listRawmById(int id);

	public String getRawmCount(int id);

	public List<Rawmaterial> listTransRawmById(int id);
	
	public Rawmaterial getRawmSellerById(int id);
	
	public Rawmaterial getRawmPurchaserById(int id);
	
	public Rawmaterial getRawmByPurchaseId(int id);
	
	public void updateState(int purchaseId);
	
	public void updateTxId(String txId);
	
}
