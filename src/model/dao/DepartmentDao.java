package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface DepartmentDao {

	void insert(Department obj); // insert recebendo um department como argumento

	void update(Department obj);

	void deleteById(Integer id);

	Department findById(Integer id); 	/* Retorna um Department e recebe como argumento um id. Essa operação é
										 * responsável por pegar esse ID e  consultar no banco de dados o objeto com o
										 * mesmo ID, se existir, retorna o Department, se não, retorna nulo.
										 */
	
	
	List<Department> findAll();	// Retorna uma lista de Departamentos
	
	
	

}
