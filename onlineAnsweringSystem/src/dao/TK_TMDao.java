package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.TiKu;
import domain.TiMu;

import util.DataSourceUtils;

public class TK_TMDao {
	private QueryRunner queryRunner = new QueryRunner(
			DataSourceUtils.getDataSource());

	// 根据tkid 查询 tm
	public List<TiMu> queryTMByTKid(int tkid) throws SQLException {
		String sql = "SELECT * FROM timu WHERE tmid IN(SELECT tmid FROM tiku_timu WHERE tkid = ?)";
		return queryRunner.query(sql, new BeanListHandler<TiMu>(TiMu.class),
				tkid);
	}

	// 添加tm到tk
	public void addtm_tk(int tkid, int tmid) throws SQLException {
		String sql = "insert into tiku_timu(tkid,tmid) values(?,?)";
		Object[] params = { tkid, tmid };
		queryRunner.update(sql, params);
	}

	// 删除
	public void deltm_tk(int tmid) throws SQLException {
		String sql = "delete from tiku_timu where tmid = ?";
		queryRunner.update(sql, tmid);
	}
	
	//通过tkid 查询 已添加题目的总分数
	public Object queryTMScoresBytkid (int tkid) throws SQLException{
		String sql = "SELECT SUM(tmscore) AS tmscores FROM timu WHERE tmid IN( SELECT tmid FROM tiku_timu WHERE tkid = ?)";
		return queryRunner.query(sql, new ScalarHandler(),tkid);
	}
}
