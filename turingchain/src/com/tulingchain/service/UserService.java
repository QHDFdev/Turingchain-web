package com.tulingchain.service;

import java.util.List;

import com.tulingchain.model.Noder;
import com.tulingchain.model.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void active(User u);
	
	public User findById(Integer id);

	public void updateUser(User user);

	public List<User> getAll();

	public void delete(Integer id);

	public User queryLogin(String email, String password);
	
	public User queryLogin2(User user);

	public User findByName(String userName);

	public User findByEmail(String email);

	public void updatePwd(String userName,String newPassword);

	public void deleteUser(User user);

	public void deleteAdd(Integer id);

	public void upUserImg(User user);

}
