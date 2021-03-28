package service;

import java.sql.SQLException;
import java.util.List;


import dao.MSGDao;
import domain.MSG;
import domain.Users_ZGT;

public class MSGService {
	private MSGDao msgDao = new MSGDao();

	// 查询
	public List<MSG> queryMSGAll() {
		try {
			return msgDao.queryMSGAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	// 添加
	public void addMSG(MSG msg) {
		try {
			msgDao.addMSG(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 编辑
	public void editMSG(MSG msg) {
		try {
			msgDao.editMSG(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除
	public void delMSG(int msg) {
		try {
			msgDao.delMSG(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 添加面试官到考场
	public void addmsg_kc(int kcid, int msgid) {
		try {
			msgDao.addmsg_kc(kcid, msgid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 清除
	public void delmsg_kc(int msgid) {
		// TODO Auto-generated method stub
		try {
			msgDao.delmsg_kc(msgid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询该考场的面试官
	public List<MSG> lookmsg_kc(int kcid) {
		try {
			return msgDao.lookmsg_kc(kcid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	// 面试官登录
	public MSG login(MSG msg) {
		try {
			return msgDao.login(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	// 面试官更改个人信息
	public void updateMSG(MSG msg) {
		try {
			msgDao.updateMSG(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 通过msgid查询msg
	public List<MSG> queryMSGByMSGid(int msgid) {
		try {
			return msgDao.queryMSGByMSGid(msgid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 查询该面试官下所有考生主观题
	public List<Users_ZGT> queryUsers_zgtByMSGid(int msgid) {
		try {
			return msgDao.queryUsers_zgtByMSGid(msgid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 通过msgaccount查询msgid
	public Object queryMSGid(String msgaccount) {
		try {
			return msgDao.queryMSGid(msgaccount);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
