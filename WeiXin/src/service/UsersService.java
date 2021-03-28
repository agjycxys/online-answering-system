package service;

import java.sql.SQLException;
import java.util.List;

import dao.UsersDao;
import domain.Users;

public class UsersService {
	private UsersDao usersDao = new UsersDao();

	// 添加用户信息
	public void addUserInfo(Users users) {
		try {
			usersDao.addUserInfo(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 存储用户客观题成绩
	public void addKGTscore(int kgtscore, String openid) {
		try {
			usersDao.addKGTscore(kgtscore, openid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询用户名字
	public Object queryNameByOpenid(String openid) {
		try {
			return usersDao.queryNameByOpenid(openid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据姓名查询users
	public List<Users> queryUsersByName(String usersname) {
		try {
			return usersDao.queryUsersByName(usersname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据最大成绩查询users
	public List<Users> queryUsersByMaxScore(int score) {
		try {
			return usersDao.queryUsersByMixScore(score);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据最小成绩查询users
	public List<Users> queryUsersByMinScore(int score) {
		try {
			return usersDao.queryUsersByMinScore(score);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 综合查询
	public List<Users> queryUsersByScore(int minscore, int maxscore) {
		try {
			return usersDao.queryUsersByScore(minscore, maxscore);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 查询用户信息
	public List<Users> queryUsers() {
		try {
			return usersDao.queryUsers();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
