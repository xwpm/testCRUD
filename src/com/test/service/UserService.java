package com.test.service;

import java.util.List;

import com.test.bean.Users;
import com.test.dao.UserDao;

public class UserService {

	private UserDao dao = new UserDao();

	/*
	 * 添加用户
	 */
	public int addUser(Users user) {

		return dao.addUser(user);
	}

	/*
	 * 查询所有用户
	 */
	public List<Users> selectAllUsers() {

		return dao.selectAllUsers();
	}

	/*
	 * 根据id删除用户
	 */
	public int deleteUserById(String uid) {
		return dao.deleteUserById(uid);
	}

	/*
	 * 根据ID查询对象并将对象返回
	 */
	public Users queryUserById(String uid) {
		return dao.queryUserById(uid);
	}

	/*
	 * 更新用户
	 */
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

}
