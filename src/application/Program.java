package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dp = new Department(1, "Victor");
		Seller se = new Seller(1, "Victor Emanuel", "Victor@gmail.com", new Date(), 3000.00, dp);
		System.out.println(se);

	}

}