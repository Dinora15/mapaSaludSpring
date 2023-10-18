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

	@Override
	public List<country> listarTodosLosCountries() {		
		return repositorio.findAll();
	}
	

	@Override
public Page<country> findAll(Pageable pageable) {
	
	return repositorio.findAll( pageable);
}


	@Override
	public country guardarCountry(country country) {
		return repositorio.save(country);
	}

	@Override
	public country obtenerCountryPorId(Long Id) {
		return repositorio.findById(Id).get();
	}

	@Override
	public country actualizarCountry(country country) {
		// TODO Auto-generated method stub
		return repositorio.save(country);
	}

	@Override
	public void eliminarCountry(Long Id) {
		repositorio.deleteById(Id);
	}


}
