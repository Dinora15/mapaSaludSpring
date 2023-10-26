package unedMasterSaludMapaSpring.servicio;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unedMasterSaludMapaSpring.entidad.*;


public interface IndicadorServicio {
	
    // Obtiene una lista de todos los indicadores
    public List<Indicador> listarTodosLosIndicadores();

    // Obtiene una lista paginada de todos los indicadores
    public Page<Indicador> findAll(Pageable pageable);

    // Guarda un indicador en la base de datos
    public Indicador guardarIndicador(Indicador indicador);

    // Obtiene un indicador por su ID
    public Indicador obtenerIndicadorPorId(Long Id);

    // Actualiza un indicador en la base de datos
    public Indicador actualizarIndicador(Indicador indicador);

    // Elimina un indicador por su ID
    public void eliminarIndicador(Long Id);
	
}
