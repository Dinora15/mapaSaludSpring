package unedMasterSaludMapaSpring.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapaSpring.entidad.*;



@Repository
// Esta interfaz hereda métodos CRUD estándar de JpaRepository para la entidad "Data"
public interface DataRepositorio extends JpaRepository<Data, Long>{


}
