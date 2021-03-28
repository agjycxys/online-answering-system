package service;

import java.sql.SQLException;
import java.util.List;


import dao.TiMuDao;
import domain.TiMu;

public class TiMuService {
	private TiMuDao timuDao = new TiMuDao();
	//查询
	public List<TiMu> queryTiMuAll(){
		try {
			return timuDao.queryTiMuAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//添加
	public void addTiMu(TiMu timu){
		try {
			timuDao.addTiMu(timu);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//编辑
	public void editTiMu(TiMu timu){
		try {
			timuDao.editTiMu(timu);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//删除
	public void delTiMu(int tmid){
		try {
			timuDao.delTiMu(tmid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
