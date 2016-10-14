package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Payment;

public interface PaymentMapper {
	public abstract int save(Payment payment);
	public abstract List<Payment> listAll(int id);
	public abstract void updateCreateThrnsferId(Payment payment);
}
