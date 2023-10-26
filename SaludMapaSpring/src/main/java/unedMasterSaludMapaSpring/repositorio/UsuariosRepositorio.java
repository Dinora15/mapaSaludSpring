package unedMasterSaludMapaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import unedMasterSaludMapaSpring.entidad.Usuarios;


// Esta interfaz hereda métodos CRUD estándar de JpaRepository para la entidad "usuarios"
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long>{

	   Usuarios findByUsername(String username);

}
