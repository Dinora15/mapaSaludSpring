package unedMasterSaludMapaSpring.servicio;

import java.util.List;
import unedMasterSaludMapaSpring.entidad.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataServicio {
	
    // Obtiene una lista de todos los datos
    public List<Data> listarTodosLosDatas();

    // Obtiene una lista paginada de todos los datos
    public Page<Data> findAll(Pageable pageable);

    // Guarda un dato en la base de datos
    public Data guardarData(Data data);

    // Obtiene un dato por su ID
    public Data obtenerDataPorId(Long Id);

    // Actualiza un dato en la base de datos
    public Data actualizarData(Data data);

    // Elimina un dato por su ID
    public void eliminarData(Long Id);

}
