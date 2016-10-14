package com.tulingchain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulingchain.mapper.ApplyMapper;
import com.tulingchain.mapper.NoderMapper;
import com.tulingchain.mapper.UserMapper;
import com.tulingchain.model.User;
import com.tulingchain.service.UserService;
import com.tulingchain.utils.MailUitls;
import com.tulingchain.utils.UUIDUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ApplyMapper applyMapper;
	
	@Autowired
	private NoderMapper noderMapper;

	@Override
	public void addUser(User user) {
		
		/*生成序列号
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);*/
		
		user.setRegDate(new Date());
		user.setUserState("消费者");
		System.out.println(user);
		userMapper.add(user);
		
		// 发送邮件
		//MailUitls.sendMail(user.getEmail(), code);
		
	}

	/*@Override
	public User findByCode(String code) {
		return userMapper.selectByCode(code);
	}
*/
	@Override
	public void active(User user) {
		userMapper.update(user);
	}

	@Override
	public User findById(Integer id) {
		return userMapper.getById(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
	}

	@Override
	public User queryLogin(String email,String password) {
		return userMapper.queryLogin(email, password); 
	}

	@Override
	public User findByName(String userName) {
		return userMapper.getByName(userName);
	}

	@Override
	public User findByEmail(String email) {
		return userMapper.getByEmail(email);
	}

	@Override
	public void updatePwd(String userName, String newPassword) {
		userMapper.updatePwd(userName,newPassword);
	}

	@Override
	public void deleteAdd(Integer id) {
		applyMapper.delete(id);
		userMapper.delete(id);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upUserImg(User user) {
		userMapper.updateImg(user);
	}

	@Override
	public User queryLogin2(User user) {
		return userMapper.queryLogin2(user);
	}
}
