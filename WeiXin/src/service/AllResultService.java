package service;

import java.sql.SQLException;
import java.util.List;

import dao.AllResultDao;
import domain.AllResult;

public class AllResultService {
	
	 private AllResultDao allResultDao = new AllResultDao();
	 
	 //储存所有用户答案对错
	 public void addResult(AllResult allResult){
		 try {
			allResultDao.addResult(allResult);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 //查询所有用户答案对错
	 public List<AllResult> queryResults(int kcid,int tkid){
		 try {
			return allResultDao.queryResults(kcid, tkid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	
}
