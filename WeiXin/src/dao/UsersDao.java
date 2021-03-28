package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Users;


import util.DataSourceUtils;

public class UsersDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	
	//添加用户信息
	public void addUserInfo(Users users) throws SQLException{
		String sql = "INSERT INTO users(usersname,xingbie,dianhua,xuexiao,zhuanye,xueli,wxname,openid,kcid) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params = {users.getUsersname(),users.getXingbie(),users.getDianhua(),users.getXuexiao(),users.getZhuanye(),users.getXueli(),users.getWxname(),users.getOpenid(),users.getKcid()};
		queryRunner.update(sql,params);
	}
	//存储用户客观题成绩
	public void addKGTscore(int kgtscore,String openid) throws SQLException{
		String sql = "update users set kgtscore = ? where openid = ?";
		Object[] params = {kgtscore,openid};
		queryRunner.update(sql, params);
	}
	//查询用户名字
	public Object queryNameByOpenid(String openid) throws SQLException{
		String sql = "SELECT usersname FROM users WHERE openid=?";
		return queryRunner.query(sql, new ScalarHandler(),openid);
	}
	//根据姓名查询users
	public List<Users> queryUsersByName(String usersname) throws SQLException{
		String sql = "SELECT * FROM users WHERE usersname = ?";
		return queryRunner.query(sql, new BeanListHandler<Users>(Users.class),usersname);
	}
	//根据最大成绩查询users
	public List<Users> queryUsersByMixScore(int score) throws SQLException{
		String sql = "SELECT * FROM users WHERE score <= ?";
		return queryRunner.query(sql, new BeanListHandler<Users>(Users.class),score);
		
	}
	//根据最小成绩查询users
	public List<Users> queryUsersByMinScore(int score) throws SQLException {
		String sql = "SELECT * FROM users WHERE score >= ?";
		return queryRunner.query(sql, new BeanListHandler<Users>(Users.class),score);
	}
	//综合查询
	public List<Users> queryUsersByScore(int minscore,int maxscore) throws SQLException{
		String sql = "SELECT * FROM users WHERE score >= ? and score <= ?";
		return queryRunner.query(sql, new BeanListHandler<Users>(Users.class),minscore,maxscore);
	}
	public List<Users> queryUsers() throws SQLException{
		String sql = "SELECT * FROM users";
		return queryRunner.query(sql, new BeanListHandler<Users>(Users.class));
	}
}
