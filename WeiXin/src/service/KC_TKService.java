package service;

import java.sql.SQLException;
import java.util.List;

import dao.KC_TKDao;
import domain.KC_TK;
import domain.TiKu;

public class KC_TKService {
	private static KC_TKDao kc_TKDao = new KC_TKDao();
	//根据kcid 查询 tk
	public List<TiKu> queryTkByKCid(int kcid){
		try {
			return kc_TKDao.queryTkByKCid(kcid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	////添加tk到kc
	public void addtk_kc(int kcid,int tkid){
		try {
			kc_TKDao.addtk_kc(kcid, tkid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除
	public void deltk_kc(int tkid){
		try {
			kc_TKDao.deltk_kc(tkid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据kcid 随机 取出一个tkid
	public Object queryTKidByKCid(int kcid){
		try {
			return kc_TKDao.queryTKidByKCid(kcid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}