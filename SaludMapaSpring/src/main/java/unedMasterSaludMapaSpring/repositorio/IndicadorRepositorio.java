package unedMasterSaludMapaSpring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapaSpring.entidad.Indicador;

@Repository
  // Esta interfaz hereda métodos CRUD estándar de JpaRepository para la entidad "Indicador"
public interface IndicadorRepositorio extends JpaRepository<Indicador, Long>{

}
