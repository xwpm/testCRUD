package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.bean.Users;
import com.test.dbcfg.DBConfigUtils;

public class UserDao {

	/*
	 * 添加用户
	 */
	public int addUser(Users user) {
		int reg = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into u_users (u_name,u_password) values (?,?)";
		try {
			conn = DBConfigUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_password());
			// 执行 结果
			reg = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("prepareStatement异常" + e.getMessage());
		} finally {
			DBConfigUtils.close(conn, ps, null);
		}
		return reg;
	}

	/*
	 * 查询所有用户
	 */
	public List<Users> selectAllUsers() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Users> list = new ArrayList<>();
		try {
			conn = DBConfigUtils.getConnection();
			String sql = "select * from u_users";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setU_id(rs.getInt("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_password(rs.getString("u_password"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement异常" + e.getMessage());
		} finally {
			System.out.println(list.size());
			DBConfigUtils.close(conn, ps, rs);
		}
		return list;
	}

	/*
	 * 根据ID删除用户
	 */
	public int deleteUserById(String uid) {
		int reg = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from u_users where u_id=?";
		try {
			conn = DBConfigUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(uid));
			// 执行 结果
			reg = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("prepareStatement异常" + e.getMessage());
		} finally {
			DBConfigUtils.close(conn, ps, null);
		}
		return reg;
	}

	/*
	 * 根据ID查询用户
	 */
	public Users queryUserById(String uid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users user = new Users();
		try {
			conn = DBConfigUtils.getConnection();
			String sql = "select * from u_users where u_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(uid));
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setU_id(rs.getInt("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_password(rs.getString("u_password"));
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement异常" + e.getMessage());
		} finally {
			DBConfigUtils.close(conn, ps, rs);
		}
	
		return user;
	}

	/*
	 * 更新用户
	 */
	public int updateUser(Users user) {
		int reg = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update u_users set u_name = ?, u_password = ? where u_id = ?";
		try {
			conn = DBConfigUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_password());
			ps.setInt(3, user.getU_id());
			// 执行 结果
			reg = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("prepareStatement异常" + e.getMessage());
		} finally {
			DBConfigUtils.close(conn, ps, null);
		}
		return reg;
	}
}
