package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// Classe responsável por instanciar as classes Dao.
	
	public static SellerDao createSellerDao() {  // create SellerDao vai retornar um SellerDao.
		return new SellerDaoJDBC(DB.getConnection());
		
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
