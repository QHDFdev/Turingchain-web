package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Discount;

public interface DiscountMapper {
	public abstract int save(Discount discount);
	public abstract List<Discount> listAll(int id);
	public abstract void updateCreateThrnsferId(Discount discount);
	
}
