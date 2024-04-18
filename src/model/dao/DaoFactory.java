package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// Classe responsável por instanciar as classes Dao.
	
	public static SellerDao createSellerDao() {  // create SellerDao vai retornar um SellerDao.
		return new SellerDaoJDBC();
		
	}

}
