package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import unedMasterSaludMapaSpring.dto.UsuariosRegistroDTO;
import unedMasterSaludMapaSpring.entidad.Usuarios;



public interface UsuariosServicio extends UserDetailsService{
	
	Usuarios save(UsuariosRegistroDTO registroDTO);
    
	public List<Usuarios> getAll();

}
