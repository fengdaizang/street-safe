package com.service.impl;

import com.dao.UserInfoDao;
import com.entity.UserInfo;
import com.service.UserInfoService;

/*
 * 用户信息service服务接口的实现类
 */
public class UserInfoServiceImpl implements UserInfoService{
	
	public static UserInfoDao userInfoDao = new UserInfoDao();

	@Override
	public UserInfo userLogin(UserInfo userInfo) {
		return userInfoDao.userLogin(userInfo);
	}

	@Override
	public int userRegist(UserInfo userInfo) {
		return userInfoDao.userRegist(userInfo);
	}

//	@Override
//	public ActionResult registerUser(UserInfo userInfo) {
//		// TODO Auto-generated method stub
//		ActionResult actionResult = new ActionResult();
//		Integer influenceRowsNumber = userInfoDao.registerUser(userInfo);
//		if(influenceRowsNumber > 0){
//			actionResult.setActionState(true);
//			actionResult.setMessage("用户注册成功,请登录");
//		}else{
//			actionResult.setActionState(false);
//			actionResult.setMessage("用户注册失败,请重试");
//		}
//		return actionResult;
//	}
//
//	@Override
//	public Boolean checkUserName(String userName) {
//		// TODO Auto-generated method stub
//		Boolean resultForCheckUserName = true;
//		UserInfo userInfo = userInfoDao.getUserInfoByUserName(userName);
//		if(userInfo.getId() != null){
//			resultForCheckUserName = false;
//		}
//		return resultForCheckUserName;
//	}
//
//	@Override
//	public UserInfo userLogin(UserInfo userInfo){
//		// TODO Auto-generated method stub
//		return userInfoDao.checkUserInfoByUserNameAndUserPwd(userInfo);
//	}
//
//	@Override
//	public List<UserInfo> listAllUsetInfo() {
//		// TODO Auto-generated method stub
//		return userInfoDao.listUserInfo();
//	}

}
