package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.TiKu;


import util.DataSourceUtils;

public class KC_TKDao {

	private QueryRunner queryRunner = new QueryRunner(
			DataSourceUtils.getDataSource());

	// 根据kcid 查询 tk
	public List<TiKu> queryTkByKCid(int kcid) throws SQLException {
		String sql = "SELECT * FROM tiku WHERE tkid IN(SELECT tkid FROM kc_tiku WHERE kcid = ?)";
		return queryRunner.query(sql, new BeanListHandler<TiKu>(TiKu.class),kcid);
	}

	// 添加tk到kc
	public void addtk_kc(int kcid, int tkid) throws SQLException {
		String sql = "insert into kc_tiku(kcid,tkid) values(?,?)";
		Object[] params = { kcid, tkid };
		queryRunner.update(sql, params);
	}

	// 删除
	public void deltk_kc(int tkid) throws SQLException {
		String sql = "delete from kc_tiku where tkid = ?";
		queryRunner.update(sql, tkid);
	}
	//根据kcid 随机 取出一个tkid
	public Object queryTKidByKCid(int kcid) throws SQLException{
		String sql = "SELECT tkid FROM kc_tiku  WHERE kcid = ? ORDER BY RAND( ) LIMIT 1";
		return queryRunner.query(sql, new ScalarHandler(),kcid);
	}
}
