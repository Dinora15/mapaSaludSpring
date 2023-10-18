package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unedMasterSaludMapaSpring.entidad.Indicador;
import unedMasterSaludMapaSpring.repositorio.IndicadorRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class IndicadorServicioImpl  implements IndicadorServicio{

	
	
	@Autowired
	private IndicadorRepositorio repositorio;

	@Override
	public List<Indicador> listarTodosLosIndicadores() {
		
		return repositorio.findAll();
	}
	
	@Override
public Page<Indicador> findAll(Pageable pageable) {
	
	return repositorio.findAll( pageable);
}


	@Override
	public Indicador guardarIndicador(Indicador indicador) {
		return repositorio.save(indicador);
	}

	@Override
	public Indicador obtenerIndicadorPorId(Long Id) {
		
		return repositorio.findById(Id).get();
	}

	@Override
	public Indicador actualizarIndicador(Indicador indicador) {
		
		return repositorio.save(indicador);
	}

	@Override
	public void eliminarIndicador(Long Id) {
		
		repositorio.deleteById(Id);
		
	}

}
