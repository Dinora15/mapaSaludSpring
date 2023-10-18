package unedMasterSaludMapaSpring.servicio;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unedMasterSaludMapaSpring.entidad.*;


public interface IndicadorServicio {
	
	public List<Indicador> listarTodosLosIndicadores();
	
	public Page<Indicador> findAll(Pageable pageable);
	
	public Indicador guardarIndicador(Indicador indicador);

	 public Indicador obtenerIndicadorPorId(Long Id);
	    
	    public Indicador actualizarIndicador(Indicador indicador);
	    
	    public void eliminarIndicador(Long Id);

}
