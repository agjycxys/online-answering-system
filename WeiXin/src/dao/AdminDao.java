package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.Admin;


import util.DataSourceUtils;


public class AdminDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	/**
	 * 管理员登录
	 * @throws SQLException 
	 */
	public Admin login(Admin admin) throws SQLException{
		String sql = "SELECT * FROM admin WHERE adname=? AND adpwd=?";
		Admin existadmin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),admin.getAdname(),admin.getAdpwd());
		return existadmin;
	}
}
