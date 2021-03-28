package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.MSG;
import domain.Users_ZGT;


import util.DataSourceUtils;

public class MSGDao {
	private QueryRunner queryRunner = new QueryRunner(
			DataSourceUtils.getDataSource());
	//查询
	public List<MSG> queryMSGAll() throws SQLException {
		String sql = "SELECT * FROM msg";
		return queryRunner.query(sql, new BeanListHandler<MSG>(MSG.class));
	}

	// 添加
	public void addMSG(MSG msg) throws SQLException {
		String sql = "INSERT INTO msg(msgaccount,msgpwd,msgname,msgphone) VALUES(?,?,?,?)";
		Object[] params = {msg.getMsgaccount(), msg.getMsgpwd(),msg.getMsgname(),msg.getMsgphone()};
		queryRunner.update(sql, params);
	}

	// 编辑
	public void editMSG(MSG msg) throws SQLException {
		String sql = "UPDATE msg SET msgaccount=?,msgpwd=?,msgname=?,msgphone=? where msgid=?";
		Object[] params = { msg.getMsgaccount(), msg.getMsgpwd(),msg.getMsgname(),msg.getMsgphone(),msg.getMsgid()};
		queryRunner.update(sql, params);
	}

	// 删除
	public void delMSG(int msg) throws SQLException {
		String sql = "DELETE FROM msg WHERE msgid =?";
		queryRunner.update(sql, msg);
	}
	
	//添加面试官到考场
	public void addmsg_kc(int kcid,int msgid) throws SQLException{
		String sql = "update msg set kcid = ? where msgid =?";
		Object[] params = {kcid,msgid};
		queryRunner.update(sql,params);
	}
    //清除考场号
	public void delmsg_kc(int msgid) throws SQLException {
		String sql ="UPDATE msg SET kcid = NULL WHERE msgid =?";
		queryRunner.update(sql,msgid);
	}
	//查询该考场的面试官
	public List<MSG> lookmsg_kc(int kcid) throws SQLException{
		String sql = "SELECT * FROM msg WHERE kcid = "+kcid;
		return queryRunner.query(sql,new BeanListHandler<MSG>(MSG.class));
		
	}
	//面试官登录
	public MSG login(MSG msg) throws SQLException{
		String sql = "SELECT * FROM msg WHERE msgaccount=? AND msgpwd=?";
		MSG existmsg = queryRunner.query(sql, new BeanHandler<MSG>(MSG.class),msg.getMsgaccount(),msg.getMsgpwd());
		return existmsg;
	}
	//通过msgaccount查询msgid
	public Object queryMSGid(String msgaccount) throws SQLException{
		String sql = "select msgid from msg where msgaccount = ?";
		return queryRunner.query(sql, new ScalarHandler(),msgaccount);
	}
	//面试官更改个人信息
	public void updateMSG(MSG msg) throws SQLException{
		String sql = "update msg set msgphone = ? where msgid = ?";
		Object[] params = {msg.getMsgphone(),msg.getMsgid()};
		queryRunner.update(sql, params);
	}
	//通过msgid查询msg
	public List<MSG> queryMSGByMSGid(int msgid) throws SQLException{
		String sql = "SELECT * FROM msg where msgid = ?";
		return queryRunner.query(sql, new BeanListHandler<MSG>(MSG.class),msgid);
	}
	//查询该面试官下所有考生主观题
	public List<Users_ZGT> queryUsers_zgtByMSGid(int msgid) throws SQLException{
		String sql = "SELECT * FROM users_zgt WHERE  openid IN(SELECT openid FROM users  WHERE kcid = (SELECT kcid FROM msg WHERE msgid =?))";
		return queryRunner.query(sql, new BeanListHandler<Users_ZGT>(Users_ZGT.class),msgid);
	}
}
