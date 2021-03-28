package service;

import java.sql.SQLException;
import java.util.List;


import dao.KCDao;
import domain.KC;

public class KCService {
	private KCDao kcDao = new KCDao();

	// 查询
	public List<KC> queryKCAll() {
		try {
			return kcDao.queryKCAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 添加
	public void addKC(KC kc) {
		try {
			kcDao.addKC(kc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 编辑
	public void editKC(KC kc) {
		try {
			kcDao.editKC(kc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除
	public void delKC(int kcid) {
		try {
			kcDao.delKC(kcid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 通过kcid查询kcname
	public KC queryKCNameByKCid(int kcid) {
		try {
			return kcDao.queryKCNameByKCid(kcid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 通过kcid查询starttime
	public Object queryStarttimeByKCid(int kcid) {
			try {
				return kcDao.queryStarttimeByKCid(kcid);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	//通过kcid 查询endtime
	public Object queryEndtimeByKCid(int kcid){
		try {
			return kcDao.queryEndtimeByKCid(kcid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
		}
}
