package unedMasterSaludMapaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import unedMasterSaludMapaSpring.entidad.Usuarios;



public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long>{

	   Usuarios findByUsername(String username);

}
