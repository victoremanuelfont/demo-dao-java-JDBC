package model.dao.impl; // pacote que fica as classes que terão as implementações

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn; // Chama-se Dependencia, que é para realizar a conexão com o Banco de Dados.
	// Para forçar a injeção de dependencia, faz-se um construtor:
	// Desse modo, conn vai estar presente em toda a classe SellerDaoJDBC

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) { // Para retornar um vendedor por ID
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(

					/*
					 * SQL QUERY: BUSCANDO TODOS os campos de Seller(Vendedor) , mais o nome do
					 * Departamento, que foi apelidado de "DepName" Faz-se um INNER JOIN para buscar
					 * os dados da tabela seller e da tabela department mais uma restrição (WHERE)
					 * onde o ID do vendedor ser igual a ?(o valor que eu quiser)
					 */

					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id); // st.setInt( numero da posição do '?', parametro do método)
			rs = st.executeQuery(); // rs vai receber o valor da resposta da execução do st.setInt()... atraves do
									// executeQuery()

			if (rs.next()) { // Para testar se veio resultado, pois sempre a tabela começa na posição zero
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId")); // procurando o valor do id do Department, que se chama
														// DepartmentId
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);
				return obj;
			}
			return null; // Para quando o if retornar zero. Significa que não existe nenhum vendedor com
							// esse ID.
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// DB.closeConnection(); Não fecha a conexão pois dentro do seller da pra fazer
			// varias conexoes, e esse método foi apenas uma delas. 
		}

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
