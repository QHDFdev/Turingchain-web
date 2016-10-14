package com.tulingchain.mapper;

import java.util.Date;
import java.util.List;

import com.tulingchain.model.Noder;

public interface NoderMapper {
	
	public void save(Noder noder);
	
	public void delete(Integer id);
	
	public void update(Noder noder);
	
	public List<Noder> listAll();
	
	public Noder getNoderByName(String noderName);
	
	public Noder getNoderByEmail(String email);

	public Noder queryLogin(Noder noder);

	public Noder getNoderByComNum(String comNum);

	public int getNoderByComId(String comId);
	
	public Noder getNoderByComName(String comName);

	public int updateState(Noder noder);

	public List<Noder> listAllByState();

	public Noder getNoderById(int id);
	
	public List<Noder> listAllByState2();

	public int deleteNoder(Noder noder);

	public Noder getNoderSer(int id);
	
	public String getNoderIpSer(int id);

	public String getNoderPubKeySer(int id);

	public Date getNoderRegDateSer(int id);

	public String getNoderRegUserCountSer(int id);

	public void updateImg(Noder noder);

	public void updatePwd(String noderName, String newPassword);
	
}
