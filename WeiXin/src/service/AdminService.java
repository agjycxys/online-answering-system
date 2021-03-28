package service;

import java.sql.SQLException;


import dao.AdminDao;
import domain.Admin;

public class AdminService {
	
	public Admin login(Admin admin){
		try {
			AdminDao adminDao = new AdminDao();
			return adminDao.login(admin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
