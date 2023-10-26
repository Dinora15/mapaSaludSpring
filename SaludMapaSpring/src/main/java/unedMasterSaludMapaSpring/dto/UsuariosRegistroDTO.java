package unedMasterSaludMapaSpring.dto;

public class UsuariosRegistroDTO {

	private Long id;	
	private String username;
	private String password;
	
	// Constructor predeterminado
	public UsuariosRegistroDTO() {
		super();
	}

	// Constructor con parámetros username y password
	public UsuariosRegistroDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// Constructor con parámetros id, username y password
	public UsuariosRegistroDTO(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// Métodos getter y setter para id
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	// Métodos getter y setter para username
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	// Métodos getter y setter para password
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
