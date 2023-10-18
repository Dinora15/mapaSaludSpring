package unedMasterSaludMapaSpring.entidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	 @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinTable(
			 name="user_roles",
			 joinColumns=@JoinColumn(
					     name="user_id", referencedColumnName="id"),
			 inverseJoinColumns=@JoinColumn(
					     name="rol_id", referencedColumnName="id")
					 )					 
			 
	 private Collection<Roles> roles;;
	 

	public Usuarios(Integer id, String username, String password, Collection<Roles> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Usuarios(String username, String password, Collection<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Usuarios() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	
	 

}
