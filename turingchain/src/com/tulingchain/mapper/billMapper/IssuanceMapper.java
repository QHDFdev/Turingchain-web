package com.tulingchain.mapper.billMapper;

import java.util.List;

import com.tulingchain.model.bill.Issuance;

public interface IssuanceMapper {
	public abstract int save(Issuance issuance);
	public abstract List<Issuance> listAll(int id);
	public abstract String selectCreateIdByid(int id);
	public abstract void updateCreateThrnsferId(Issuance inssuance);
	public abstract List<Issuance> selectIsDiscounted(int id);
	public abstract Issuance selectIssuanceByCreateId(String createId);
	public abstract void updateDiscounted(Issuance issuance);
}
