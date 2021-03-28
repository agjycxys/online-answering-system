package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.AllResult;

import util.DataSourceUtils;

public class AllResultDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	/**
	 * 存储用户答案对错
	 * @throws SQLException 
	 */
	public void addResult(AllResult allResult) throws SQLException{
		String sql = "INSERT INTO allresult (openid,kcid,tkid,results) VALUES (?,?,?,?)";
		Object[] params = {allResult.getOpenid(),allResult.getKcid(),allResult.getTkid(),allResult.getResults()};
		queryRunner.update(sql, params);
	}
	/**
	 * 查询用户答案对错
	 * @throws SQLException 
	 */
	public List<AllResult> queryResults(int kcid,int tkid) throws SQLException{
		String sql ="SELECT * FROM allresult WHERE kcid = ? AND tkid = ?";
		Object[] params = {kcid,tkid};
		return queryRunner.query(sql, new BeanListHandler<AllResult>(AllResult.class), params);
	}
}
