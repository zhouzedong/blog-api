package com.zzd.service;

import java.util.List;

import com.zzd.entity.User;

/**
 * @author zzd
 * <p>
 * 2018年1月23日
 */
public interface UserService {

    List<User> findAll();

    User getUserByAccount(String account);

    User getUserById(Long id);

    Long saveUser(User user);

    Long updateUser(User user);

    void deleteUserById(Long id);
}
