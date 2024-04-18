package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	void insert(Seller obj); // insert recebendo um Seller como argumento

	void update(Seller obj);

	void deleteById(Integer id);

	Seller findById(Integer id);    /* Retorna um Seller e recebe como argumento um id. Essa operação é responsável
									 * por pegar esse ID e consultar no banco de dados o objeto com o mesmo ID, se
									 * existir, retorna o Seller, se não, retorna nulo.
									 */
	
	
	List<Seller> findAll();	// Retorna uma lista de Seller 
	List <Seller> findByDepartment (Department department);//Busca pelo Department
	

}
