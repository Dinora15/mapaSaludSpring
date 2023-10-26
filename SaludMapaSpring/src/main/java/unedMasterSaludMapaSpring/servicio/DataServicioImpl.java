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
	
// Obtiene una lista de todos los datos
    @Override
    public List<Data> listarTodosLosDatas() {
        return repositorio.findAll();
    }

    // Obtiene una lista paginada de todos los datos
    @Override
    public Page<Data> findAll(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    // Guarda un dato en la base de datos
    @Override
    public Data guardarData(Data data) {
        return repositorio.save(data);
    }

    // Obtiene un dato por su ID
    @Override
    public Data obtenerDataPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    // Actualiza un dato en la base de datos
    @Override
    public Data actualizarData(Data data) {
        return repositorio.save(data);
    }

    // Elimina un dato por su ID
    @Override
    public void eliminarData(Long Id) {
        repositorio.deleteById(Id);
    }

}
