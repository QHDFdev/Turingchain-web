package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Rawmaterial;

public interface RawmaterialService {

	public void save(Rawmaterial rawmaterial);
	
	public List<Rawmaterial> listAll(int sellerId);

	public Rawmaterial getRawmById(int id);

	public List<Rawmaterial> listRawmById(int id);

	public String getRawmCount(int id);

	public List<Rawmaterial> listTransRawmById(int id);
	
	public Rawmaterial getRawmPurchaserById(int id);
	
}
