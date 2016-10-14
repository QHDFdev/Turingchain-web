package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Issuance;

public interface IssuanceService {
	public abstract String insert(Issuance issuance);
	public abstract List<Issuance> listAll(int id);
	public abstract List<Issuance> listNeedDiscounting(int id);
}
