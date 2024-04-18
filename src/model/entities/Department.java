package model.entities;

import java.io.Serializable;
import java.util.Objects;

/* No java, é necessário implementar o Serializable 
 * para que os Objetos sejam transferidos 
 * em sequencias de bits.E assim possa ser gravado em arquivo. 
 */

public class Department implements Serializable {

	private static final long serialVersionUID = 1L; // Devido a implementação do Serializable
	
	
	private Integer id;
	private String name;

	public Department() {

	}

	public Department(Integer id, String name) {

		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/*
	 * HashCode and Equals: para que meus objetos sejam comparados pelo conteúdo e
	 * não pela referência de ponteiros Nesse exemplo, está sendo comparado apenas o
	 * ID, por questões de simplicidade. O atributo name não está incluso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
