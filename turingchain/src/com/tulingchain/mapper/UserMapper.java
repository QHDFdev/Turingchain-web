package com.tulingchain.mapper;

import java.util.List;

import com.tulingchain.model.User;

public interface UserMapper {
	
	public void add(User user);
	
	public User queryLogin(String email, String password);
	
	public User queryLogin2(User user);

	//public User selectByCode(String code);
	
	public void update(User user);
	
	//public void updateState(User user);

	public User getById(Integer id);

	public List<User> getAll();

	public void delete(Integer id);
	
	public int deleteUser(User user);

	public User getByName(String userName);

	public User getByEmail(String email);

	public void updatePwd(String uerNameString ,String newPassword);

	public void deleteByName(String userName);

	public void updateImg(User user);
	
}
