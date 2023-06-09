package com.zzd.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzd.BlogApiApplicationTests;
import com.zzd.entity.User;
import com.zzd.entity.UserStatus;

public class UserServiceTest extends BlogApiApplicationTests{

	@Autowired
	private UserService userService;
	
	
/*	List<User> findAll();
	
	User findByAccount(String account);

	User getUserById(Long id);

	Long saveUser(User user);

	Long updateUser(User user);

	void deleteUserById(Long id);*/
	
	@Test
	public void saveUserTest() {
		User u = new User();
		u.setAccount("zzd");
		u.setNickname("泽西西");
		u.setPassword("123456");
		u.setAdmin(false);
		u.setCreateDate(new Date());
		u.setEmail("1062817070@qq.com");
		u.setMobilePhoneNumber("18396816462");
		u.setStatus(UserStatus.normal);
		Long id = userService.saveUser(u);
		System.out.println(id);
	}
	
	@Test
	public void getUserById() {
		Long id = 3L;
		User u = userService.getUserById(id);
		System.out.println(u);
	}
	
	@Test
	public void findAllTest() {
		List<User> us = userService.findAll();
		System.out.println(us);
	}
	
	@Test
	public void updateUserTest() {
		User u = new User();
		Long id = 3L;
		u.setId(id);
		u.setNickname("史明辉222");
		userService.updateUser(u);
	}
	
	@Test
	public void deleteTest() {
		Long id = 3L;
		userService.deleteUserById(id);
		
	}
	
}
