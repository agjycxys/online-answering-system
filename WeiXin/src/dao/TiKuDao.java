package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.TiKu;


import util.DataSourceUtils;

public class TiKuDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	/**
	 * 查询题库数据
	 * 返回List<TiKu> 集合
	 * @throws SQLException 
	 */
	public List<TiKu> queryTiKuAll() throws SQLException{
		String sql = "SELECT * FROM tiku";
		return queryRunner.query(sql, new BeanListHandler<TiKu>(TiKu.class));	
	}
	/**
	 * 添加题库数据
	 * 传递TiKu对象
	 * @param tiku
	 * @throws SQLException 
	 */
	public void addTiKu(TiKu tiku) throws SQLException{
		
		String sql ="INSERT INTO tiku(tkname,tkscore) VALUES(?,?)";
		Object[] params ={tiku.getTkname(),tiku.getTkscore()};
		queryRunner.update(sql, params);	
	}
	/**
	 * 编辑
	 * @throws SQLException 
	 */
	public void editTiKu(TiKu tiku) throws SQLException{
		String sql="UPDATE tiku SET tkname=?,tkscore=? WHERE tkid=?";
		Object[] params ={tiku.getTkname(),tiku.getTkscore(),tiku.getTkid()};
		queryRunner.update(sql, params);
	}
	/**
	 * 删除
	 * @throws SQLException 
	 */
	public void delTiKu(int tkid) throws SQLException{
		String sql = "DELETE FROM tiku WHERE tkid =?";
		queryRunner.update(sql, tkid);
	}
	
	//通过tkid查询tkname
	public String queryTKNameByTKid(int tkid) throws SQLException{
		String sql = "select tkname from tiku where tkid = ?";
		return (String) queryRunner.query(sql, new ScalarHandler(),tkid);
	}
	//根据tkid查询tkscore
	public String queryTKScoreByTkid(int tkid) throws SQLException{ 
		String sql = "select tkscore from tiku where tkid = ?";
		return (String) queryRunner.query(sql, new ScalarHandler(),tkid);
	}
}
