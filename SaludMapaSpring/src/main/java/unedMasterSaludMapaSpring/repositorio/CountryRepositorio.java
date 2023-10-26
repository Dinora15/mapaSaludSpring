package unedMasterSaludMapaSpring.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapaSpring.entidad.country;


// Esta interfaz hereda métodos CRUD estándar de JpaRepository para la entidad "country"
@Repository
public interface CountryRepositorio extends JpaRepository<country, Long>{


}
