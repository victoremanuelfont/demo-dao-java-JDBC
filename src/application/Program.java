package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3); // Para buscar o vendedor cujo codigo ID é 3
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment =====");
		Department department = new Department(2,null); // vai listar todos do departamento 2, que é chamado de eletronics
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n==== TEST 3: seller findAll =====");
		list = sellerDao.findAll(); // Mostrar todos os vendedores
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n==== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Joao", "Joao@outlok.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("inserido, novo ID = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Victor Emanuel");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
	}

}
