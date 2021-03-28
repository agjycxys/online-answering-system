package service;

import java.sql.SQLException;
import java.util.List;


import dao.TiKuDao;
import domain.TiKu;

public class TiKuService {
	private TiKuDao tikuDao = new TiKuDao();

	/**
	 * 查询题库数据
	 * 
	 * @return
	 */
	public List<TiKu> queryTiKuAll() {
		try {
			return tikuDao.queryTiKuAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加题库数据
	 */
	public void addTiKu(TiKu tiku) {
		try {
			tikuDao.addTiKu(tiku);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑
	 */
	public void editTiKu(TiKu tiku) {
		try {
			tikuDao.editTiKu(tiku);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除
	 */
	public void delTiKu(int tkid) {
		try {
			tikuDao.delTiKu(tkid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	// 通过tkid查询tkname
	public String queryTKNameByTKid(int tkid) {
		try {
			return tikuDao.queryTKNameByTKid(tkid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据tkid查询tkscore
	public String queryTKScoreByTkid(int tkid) {
		try {
			return tikuDao.queryTKScoreByTkid(tkid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
