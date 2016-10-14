package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Discount;
import com.tulingchain.model.bill.Issuance;

public interface DiscountService {
	public abstract String save(Discount discount);
	public abstract List<Discount> listAll(int id);
}
