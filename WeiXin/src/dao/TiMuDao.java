package dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.TiMu;

import util.DataSourceUtils;

public class TiMuDao {
	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	//查询
	public List<TiMu> queryTiMuAll() throws SQLException{
		String sql = "SELECT * FROM timu";
		return queryRunner.query(sql, new BeanListHandler<TiMu>(TiMu.class));	
	}
	//添加
	public void addTiMu(TiMu timu) throws SQLException{		
		String sql ="INSERT INTO timu(tmname,tmtype,optionA,optionB,optionC,optionD,answer,tmscore) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params ={timu.getTmname(),timu.getTmtype(),timu.getOptionA(),timu.getOptionB(),timu.getOptionC(),timu.getOptionD(),timu.getAnswer(),timu.getTmscore()};
		queryRunner.update(sql, params);	
	}
	//编辑
	public void editTiMu(TiMu timu) throws SQLException{		
		String sql ="UPDATE timu SET tmname=?,tmtype=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=?,tmscore=? where tmid=?";
		Object[] params ={timu.getTmname(),timu.getTmtype(),timu.getOptionA(),timu.getOptionB(),timu.getOptionC(),timu.getOptionD(),timu.getAnswer(),timu.getTmscore(),timu.getTmid()};
		queryRunner.update(sql, params);	
	}
	//删除
	public void delTiMu(int tmid) throws SQLException{
		String sql = "DELETE FROM timu WHERE tmid =?";
		queryRunner.update(sql, tmid);
	}
	
}
