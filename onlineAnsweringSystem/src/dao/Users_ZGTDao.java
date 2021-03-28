package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Users_ZGT;

import util.DataSourceUtils;

public class Users_ZGTDao {

	private QueryRunner queryRunner = new QueryRunner(
			DataSourceUtils.getDataSource());

	// 存储主观题
	public void AddZGT(Users_ZGT users_ZGT) throws SQLException {
		String sql = "insert into users_zgt(tmid,openid,usersname,tmname,tmscore,zgtanswer,ispingyue) values(?,?,?,?,?,?,?)";
		Object[] params = { users_ZGT.getTmid(), users_ZGT.getOpenid(),
				users_ZGT.getUsersname(), users_ZGT.getTmname(),
				users_ZGT.getTmscore(), users_ZGT.getZgtanswer(),"0"};
		queryRunner.update(sql, params);
	}

	// 存储答案
	public void AddZGTScore(String openid, int zgtscore) throws SQLException {
		String sql = "update users_zgt set zgtscore = ? where openid = ? ";
		Object[] params = { zgtscore, openid };
		queryRunner.update(sql, params);
	}

	// 如果面试官评阅 将ispingyue改为1
	public void updateIsPY(String is, String openid) throws SQLException {
		String sql = "update users_zgt set ispingyue = ? where openid = ?";
		Object[] params = { is, openid };
		queryRunner.update(sql, params);
	}
	
	//查询所有用户答案
	public List<Users_ZGT> queryAll() throws SQLException{
		String sql = "select * from users_zgt ";
		return queryRunner.query(sql, new BeanListHandler<Users_ZGT>(Users_ZGT.class));
	}
}
