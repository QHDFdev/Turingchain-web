package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Payroll;

public interface PayrollMapper {
	public abstract int save(Payroll payroll);
	public abstract List<Payroll> listAll(int id);
	public abstract void updateCreateThrnsferId(Payroll payroll);
}
