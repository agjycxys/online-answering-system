package service;

import java.sql.SQLException;
import java.util.List;

import dao.TK_TMDao;
import domain.TiMu;

public class TK_TMService {
	private TK_TMDao tk_TMDao = new TK_TMDao();

	// 根据tkid 查询 tm
	public List<TiMu> queryTMByTKid(int tkid) {
		try {
			return tk_TMDao.queryTMByTKid(tkid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 添加tm到tk
	public void addtm_tk(int tkid, int tmid) {
		try {
			tk_TMDao.addtm_tk(tkid, tmid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除
	public void deltm_tk(int tmid) {
		try {
			tk_TMDao.deltm_tk(tmid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 通过tkid 查询 已添加题目的总分数
	public Object queryTMScoresBytkid(int tkid) {
		try {
			return tk_TMDao.queryTMScoresBytkid(tkid);
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
}
