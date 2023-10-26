package unedMasterSaludMapaSpring.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Column(name="name", nullable=false)
	 private String name;
	 
	 
	

	

	//Constructor con parametro name
	public Roles(String name) {
		super();
		this.name = name;
	}




	//Constructor predeterminado
	public Roles() {
		super();
	}




	// Metodos setters and gettes para Id & name
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	

}
