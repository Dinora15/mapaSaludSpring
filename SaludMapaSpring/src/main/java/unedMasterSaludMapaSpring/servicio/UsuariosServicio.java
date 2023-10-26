package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import unedMasterSaludMapaSpring.dto.UsuariosRegistroDTO;
import unedMasterSaludMapaSpring.entidad.Usuarios;



public interface UsuariosServicio extends UserDetailsService{
	
	// Guarda un usuario utilizando DTO de registro
    Usuarios save(UsuariosRegistroDTO registroDTO);

    // Obtiene una lista de todos los usuarios
    List<Usuarios> getAll();

}
