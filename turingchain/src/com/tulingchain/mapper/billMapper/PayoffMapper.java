package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Payoff;

public interface PayoffMapper {
	public abstract int save(Payoff payoff);
	public abstract List<Payoff> listAll(int id);
	public abstract void updateCreateThrnsferId(Payoff payoff);
}
