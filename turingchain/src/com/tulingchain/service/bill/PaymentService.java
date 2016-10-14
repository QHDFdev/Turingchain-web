package com.tulingchain.service.bill;

import java.util.List;

import com.tulingchain.model.bill.Payment;

public interface PaymentService {
	public abstract String save(Payment payment);
	public abstract  List<Payment> listAll(int id);
}
