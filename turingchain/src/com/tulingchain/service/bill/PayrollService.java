package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Payroll;

public interface PayrollService {
	public abstract String save(Payroll payroll);
	public abstract List<Payroll> listAll(int id);
}
