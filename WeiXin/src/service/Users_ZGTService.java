package service;

import java.sql.SQLException;
import java.util.List;

import dao.Users_ZGTDao;
import domain.Users_ZGT;

public class Users_ZGTService {
	private Users_ZGTDao users_ZGTDao = new Users_ZGTDao();

	// 存储主观题
	public void AddZGT(Users_ZGT users_ZGT) {
		try {
			users_ZGTDao.AddZGT(users_ZGT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 存储答案
	public void AddZGTScore(String openid, int zgtscore) {
		try {
			users_ZGTDao.AddZGTScore(openid, zgtscore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 如果面试官评阅 将ispingyue改为1
	public void updateIsPY(String is, String openid) {
		try {
			users_ZGTDao.updateIsPY(is, openid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询所有用户答案
		public List<Users_ZGT> queryAll(){
			try {
				 return users_ZGTDao.queryAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
}
