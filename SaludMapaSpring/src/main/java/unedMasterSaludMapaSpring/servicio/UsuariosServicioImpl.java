package unedMasterSaludMapaSpring.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import unedMasterSaludMapaSpring.dto.UsuariosRegistroDTO;
import unedMasterSaludMapaSpring.entidad.Roles;
import unedMasterSaludMapaSpring.entidad.Usuarios;
import unedMasterSaludMapaSpring.repositorio.UsuariosRepositorio;



@Service
public class UsuariosServicioImpl implements UsuariosServicio {

	private UsuariosRepositorio repositorio;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UsuariosServicioImpl(UsuariosRepositorio repositorio, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public Usuarios save(UsuariosRegistroDTO registroDTO) {
		
		  var usuario = new Usuarios(registroDTO.getUsername(),
	                 
	                   passwordEncoder.encode(registroDTO.getPassword()), 
	                   Arrays.asList(new Roles("ROLE_ADMIN")));
		return repositorio.save(usuario);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 var usuario = repositorio.findByUsername(username);
	      if (usuario == null) {
	         throw new UsernameNotFoundException
	               ("Invalido username or password.");
	      }
	      return new org.springframework.security
	            .core.userdetails.User(usuario.getUsername(),
	               usuario.getPassword(),
	           mapRolesToAuthorities(usuario.getRoles()));
	   }

	   private Collection<? extends GrantedAuthority>
	          mapRolesToAuthorities(Collection<Roles> roles) {
	      
	      return roles.stream()
	            .map(role -> new SimpleGrantedAuthority
	                  (role.getName()))
	            .collect(Collectors.toList());
		
	}


	@Override
	public List<Usuarios> getAll() {
		
		return repositorio.findAll();
	}
	   
	   

}
