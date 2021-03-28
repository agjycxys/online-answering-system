package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.KC;


import util.DataSourceUtils;

public class KCDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	
	//查询
	public List<KC> queryKCAll() throws SQLException{
		String sql = "select * from kc";
		return queryRunner.query(sql, new BeanListHandler<KC>(KC.class));
	}
	
	//添加
	public void addKC(KC kc) throws SQLException{
		String sql = "insert into kc(kcname,starttime,endtime) VALUES(?,?,?)";
		Object[] params = {kc.getKcname(),kc.getStarttime(),kc.getEndtime()};
		queryRunner.update(sql, params);
	}
	//编辑
	public void editKC(KC kc) throws SQLException{
		String sql = "update kc set kcname = ?,starttime = ?,endtime=? where kcid =?";
		Object[] params ={kc.getKcname(),kc.getStarttime(),kc.getEndtime(),kc.getKcid()};
		queryRunner.update(sql, params);
	}
	//删除
	public void delKC(int kcid) throws SQLException{
		String sql ="delete from kc where kcid = ?";
		queryRunner.update(sql, kcid);
	}
	//通过kcid查询kcname
	public KC queryKCNameByKCid (int kcid) throws SQLException{
		String sql ="SELECT kcname from kc where kcid ="+kcid;
		return queryRunner.query(sql, new BeanHandler<KC>(KC.class));
	}
	//通过kcid查询starttime
	public Object queryStarttimeByKCid(int kcid) throws SQLException{
		String sql = "SELECT starttime FROM kc WHERE kcid = ?";
		return queryRunner.query(sql, new ScalarHandler(),kcid);
	}
	//通过kcid 查询endtime
	public Object queryEndtimeByKCid(int kcid) throws SQLException{
		String sql = "SELECT endtime FROM kc WHERE kcid = ?";
		return queryRunner.query(sql, new ScalarHandler(),kcid);
	}
}
