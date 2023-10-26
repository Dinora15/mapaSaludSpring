package unedMasterSaludMapaSpring.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import unedMasterSaludMapaSpring.entidad.country;
import unedMasterSaludMapaSpring.servicio.CountryServicio;



@Controller
public class CountryControlador {

	
@Autowired	
private CountryServicio servicio;
	
	
//Maneja la solicitud GET para /countries
@GetMapping({"/countries"})	
public String obtenerTodos(@PageableDefault( size=2, page=0)Pageable pageable, Model model){		

	// Recupera una lista paginada de países desde el servicio
	Page<country> page=servicio.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));		
	
	
	model.addAttribute("page", page);		
	var totalPages=page.getTotalPages();
	var currentPage=page.getNumber();
	var start=Math.max(1, currentPage);
	var end=Math.min(currentPage + 5, totalPages);
	
	if(totalPages >0)
	// Crea una lista de números de página para la paginación
	{
		List<Integer> pageNumbers = new ArrayList<>();
		for(int i= start; i<=end; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
	}
	 return "countries";
}


// Maneja la solicitud GET para "/countries/nuevo"
@GetMapping({"/countries/nuevo"})
public String mostrarFormularioDeRegistrarCountry(Model modelo) {
	country country=new country();
	modelo.addAttribute("country", country);
	// Devuelve la vista crear_country
	return "crear_country";
}

// Maneja la solicitud POST para /countries
@PostMapping("/countries")
public String guardarCountry(@ModelAttribute("country")country country)
{
	servicio.guardarCountry(country);
	return "redirect:/countries";
}

// Maneja la solicitud GET para /countries/editar/{id}
@GetMapping("/countries/editar/{id}")
public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
	modelo.addAttribute("country", servicio.obtenerCountryPorId(id));
	return "editar_country";
}

// Maneja la solicitud POST para /countries/{id}
@PostMapping("/countries/{id}")
public String actualizarCountry(@PathVariable Long id,@ModelAttribute("country") country country, Model modelo ) {
	
	country countryExistente=servicio.obtenerCountryPorId(id);

	// Actualiza los atributos del pais
	countryExistente.setId(id);
	countryExistente.setCountry_name(country.getCountry_name());
	countryExistente.setCountry_code(country.getCountry_code());

	// Actualiza el pais utlizando el servicio
    	servicio.actualizarCountry(countryExistente);
	
	return "redirect:/countries";
}

// Maneja la solicitud GET para "/countries/{id}"
@GetMapping({"/countries/{id}"})
public String eliminarCountry(@PathVariable Long id) {
	
	servicio.eliminarCountry(id);
	return "redirect:/countries";
}




}
