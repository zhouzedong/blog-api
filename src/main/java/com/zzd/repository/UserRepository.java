package com.zzd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzd.entity.User;

/**
 * @author zzd
 * <p>
 * 2018年1月23日
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
