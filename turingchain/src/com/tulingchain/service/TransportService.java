package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Transport;

public interface TransportService {

	public void save(Transport transport);
	
	public List<Transport> listAll();

	public String getTransCount(int id);

	public List<Transport> listDelivery(int id);
	
	public Transport getTransPurchase(int id);
	
	public Transport getTransTransport(int id);
	
	public Transport getTransPurchaser(int id);
	
	public Transport getTransSeller(int id);

	public void updateDelivery(Transport transport);

	public List<Transport> listDelivered(int id);

	public void saveRawm(Transport transport);

	public void saveProd(Transport transport);

	
}
