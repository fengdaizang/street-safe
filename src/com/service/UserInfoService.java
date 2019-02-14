package com.service;


import com.entity.UserInfo;

// 用户信息的service服务接口
public interface UserInfoService {
	// 登录验证
	public UserInfo userLogin(UserInfo userInfo);
	 // 注册用户
	public int userRegist(UserInfo userInfo);

}
