package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dp = new Department(1, "Victor");
		Seller se = new Seller(1, "Victor Emanuel", "Victor@gmail.com", new Date(), 3000.00, dp);
		System.out.println(se);

		
		
	/* SOBRE A CLASSE DaoFactory: 
	 * Não vai precisar export a implementação, somente o nome da clase.
	 * Ao inves de ser > SellerDao sellerdao = new SellerDaoJDBC < vai ser: 
	 */
		SellerDao sellerDao = DaoFactory.createSellerDao(); // é uma injeção de dependencia sem explicitar a implementação
	}

}
