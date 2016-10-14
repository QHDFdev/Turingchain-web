package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Payoff;

public interface PayoffService {
	public abstract String save(Payoff payoff);
	public abstract List<Payoff> listAll(int id);
}
