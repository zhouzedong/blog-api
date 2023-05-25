package com.zzd.common.util;

import org.apache.shiro.SecurityUtils;

import com.zzd.common.constant.Base;
import com.zzd.entity.User;

/**
 * @author zzd
 * <p>
 * 2018年1月25日
 */
public class UserUtils {

    public static User getCurrentUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}
