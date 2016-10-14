package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Discounting;
import com.tulingchain.model.bill.Issuance;

public interface DiscountingMapper {
	public abstract int save(Discounting discouting);
	public abstract List<Discounting> listAll(int id);
	public abstract void updateCreateThrnsferId(Discounting discouting);
	public abstract  List<Issuance> listFinishedDiscounting(int id);

}
