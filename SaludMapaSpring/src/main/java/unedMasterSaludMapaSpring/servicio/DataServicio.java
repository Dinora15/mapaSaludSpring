package unedMasterSaludMapaSpring.servicio;

import java.util.List;
import unedMasterSaludMapaSpring.entidad.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataServicio {
	
	public List<Data> listarTodosLosDatas();
	
	public Page<Data> findAll(Pageable pageable);
	
	public Data guardarData(Data data);
	
	public Data obtenerDataPorId(Long Id);
    
    public Data actualizarData(Data data);
    
    public void eliminarData(Long Id);

}
