package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Discounting;

public interface DiscountingService {
	public abstract String save(Discounting discounting); 
	public abstract List<Discounting> listAll(int id);
}
