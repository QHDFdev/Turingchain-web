package com.tulingchain.mapper.billMapper;

import java.util.Date;
import java.util.List;

import com.tulingchain.model.bill.BillNoder;

public interface BillNoderMapper {
	public int save(BillNoder noder);
	
	public void delete(Integer id);
	
	public void update(BillNoder noder);
	
	public List<BillNoder> listAll();
	
	public BillNoder getNoderByName(String noderName);
	
	public BillNoder getNoderByEmail(String email);

	public BillNoder queryLogin(BillNoder noder);

	public BillNoder getNoderByComNum(String comNum);

	public int getNoderByComId(String comId);
	
	public BillNoder getNoderByComName(String comName);

	public int updateState(BillNoder noder);

	public List<BillNoder> listAllByState();

	public BillNoder getNoderById(int id);
	
	public List<BillNoder> listAllByState2();

	public int deleteNoder(BillNoder noder);

	public BillNoder getNoderSer(int id);
	
	public String getNoderIpSer(int id);

	public String getNoderPubKeySer(int id);
	
	public String getNoderPriKeySer(int id);

	public Date getNoderRegDateSer(int id);

	public String getNoderRegUserCountSer(int id);

	public void updateImg(BillNoder noder);
	
	public void updatePubKPriK(BillNoder noder);

	public void updatePwd(String noderName, String newPassword);
}

