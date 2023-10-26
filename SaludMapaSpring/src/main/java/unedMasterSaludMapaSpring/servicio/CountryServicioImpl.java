package unedMasterSaludMapaSpring.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import unedMasterSaludMapaSpring.repositorio.*;
import unedMasterSaludMapaSpring.entidad.country;



@Service
public class CountryServicioImpl implements CountryServicio{
	
	@Autowired
	private CountryRepositorio repositorio;

	 // Obtiene una lista de todos los países
	@Override
	public List<country> listarTodosLosCountries() {		
		return repositorio.findAll();
	}
	
	 // Obtiene una lista paginada de todos los países
	@Override
	public Page<country> findAll(Pageable pageable) {
	
		return repositorio.findAll( pageable);
	}

	// Guarda un país en la base de datos
	@Override
	public country guardarCountry(country country) {
		return repositorio.save(country);
	}

	// Obtiene un país por su ID
	@Override
	public country obtenerCountryPorId(Long Id) {
		return repositorio.findById(Id).get();
	}

	// Actualiza un país en la base de datos
	@Override
	public country actualizarCountry(country country) {
		// TODO Auto-generated method stub
		return repositorio.save(country);
	}

	// Elimina un país por su ID
	@Override
	public void eliminarCountry(Long Id) {
		repositorio.deleteById(Id);
	}


}
