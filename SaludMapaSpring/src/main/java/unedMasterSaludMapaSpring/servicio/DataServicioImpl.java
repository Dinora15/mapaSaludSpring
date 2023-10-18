package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import unedMasterSaludMapaSpring.entidad.Data;
import unedMasterSaludMapaSpring.repositorio.DataRepositorio;


@Service
public class DataServicioImpl implements DataServicio{

	
	@Autowired
	private DataRepositorio repositorio;
	
	@Override
	public List<Data> listarTodosLosDatas() {
		
		return repositorio.findAll();
	}


	@Override
public Page<Data> findAll(Pageable pageable) {
	
	return repositorio.findAll( pageable);
}
	
	@Override
	public Data guardarData(Data data) {
		
		return repositorio.save(data);
	}

	@Override
	public Data obtenerDataPorId(Long Id) {
		
		return repositorio.findById(Id).get();
	}

	@Override
	public Data actualizarData(Data data) {
		
		return repositorio.save(data);
	}

	@Override
	public void eliminarData(Long Id) {
		
		repositorio.deleteById(Id);
		
	}

}
