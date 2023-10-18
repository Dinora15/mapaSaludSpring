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
	
	
	
@GetMapping({"/countries"})	
public String obtenerTodos(@PageableDefault( size=2, page=0)Pageable pageable, Model model){		
	
	Page<country> page=servicio.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));		
	
	
	model.addAttribute("page", page);		
	var totalPages=page.getTotalPages();
	var currentPage=page.getNumber();
	var start=Math.max(1, currentPage);
	var end=Math.min(currentPage + 5, totalPages);
	
	if(totalPages >0)
	{
		List<Integer> pageNumbers = new ArrayList<>();
		for(int i= start; i<=end; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
	}
	 return "countries";
}


	
@GetMapping({"/countries/nuevo"})
public String mostrarFormularioDeRegistrarCountry(Model modelo) {
	country country=new country();
	modelo.addAttribute("country", country);
	return "crear_country";
}

@PostMapping("/countries")
public String guardarCountry(@ModelAttribute("country")country country)
{
	servicio.guardarCountry(country);
	return "redirect:/countries";
}

@GetMapping("/countries/editar/{id}")
public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
	modelo.addAttribute("country", servicio.obtenerCountryPorId(id));
	return "editar_country";
}

@PostMapping("/countries/{id}")
public String actualizarCountry(@PathVariable Long id,@ModelAttribute("country") country country, Model modelo ) {
	
	country countryExistente=servicio.obtenerCountryPorId(id);
	
	countryExistente.setId(id);
    countryExistente.setCountry_name(country.getCountry_name());
    countryExistente.setCountry_code(country.getCountry_code());
    
    
    servicio.actualizarCountry(countryExistente);
	
	return "redirect:/countries";
}

@GetMapping({"/countries/{id}"})
public String eliminarCountry(@PathVariable Long id) {
	
	servicio.eliminarCountry(id);
	return "redirect:/countries";
}




}
