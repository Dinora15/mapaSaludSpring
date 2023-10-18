package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unedMasterSaludMapaSpring.entidad.country;



public interface CountryServicio {
	
	public List<country> listarTodosLosCountries();
	
	public Page<country> findAll(Pageable pageable);
	
	 public country guardarCountry(country country);
	 
	 public country obtenerCountryPorId(Long Id);
	    
	    public country actualizarCountry(country country);
	    
	    public void eliminarCountry(Long Id);

}
