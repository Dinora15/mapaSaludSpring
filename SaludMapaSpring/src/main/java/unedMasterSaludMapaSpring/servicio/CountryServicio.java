package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unedMasterSaludMapaSpring.entidad.country;



public interface CountryServicio {
	// Obtiene una lista de todos los países
	public List<country> listarTodosLosCountries();
	// Obtiene una lista paginada de todos los países
	public Page<country> findAll(Pageable pageable);
	// Guarda un país en la base de datos
	 public country guardarCountry(country country);
	 // Obtiene un país por su ID
	 public country obtenerCountryPorId(Long Id);
	     // Actualiza un país en la base de datos
	    public country actualizarCountry(country country);
	    // Elimina un país por su ID
	    public void eliminarCountry(Long Id);

}
