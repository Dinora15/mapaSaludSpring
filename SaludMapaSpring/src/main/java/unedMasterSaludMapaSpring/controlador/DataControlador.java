package unedMasterSaludMapaSpring.controlador;

import unedMasterSaludMapaSpring.entidad.*;

import java.util.ArrayList;
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

import unedMasterSaludMapaSpring.servicio.DataServicio;

@Controller
public class DataControlador {
	@Autowired
	private DataServicio servicio;

		// Maneja la solicitud GET para "/datas"
		@GetMapping({"/datas"})	
		public String obtenerTodos(@PageableDefault( size=2, page=0)Pageable pageable, Model model){		

			// Recupera una lista paginada de datos desde el servicio
			Page<Data> page=servicio.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));		
			
			
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
			// Devuelve la vista "datas"
			return "datas";
		}

		// Maneja la solicitud GET para "/datas/nuevo"
		@GetMapping({"/datas/nuevo"})
		public String mostrarFormularioDeRegistrarData(Model modelo) {
			Data data=new Data();
			modelo.addAttribute("data", data);
			return "crear_data";
		}

		// Maneja la solicitud POST para "/datas"
		@PostMapping("/datas")
		public String guardarData(@ModelAttribute("data")Data data)
		{
			servicio.guardarData(data);
			return "redirect:/datas";
		}

		// Maneja la solicitud GET para "/datas/editar/{id}"
		@GetMapping("/datas/editar/{id}")
		public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
			modelo.addAttribute("data", servicio.obtenerDataPorId(id));
			return "editar_data";
		}

		// Maneja la solicitud POST para "/datas/{id}"
		@PostMapping("/datas/{id}")
		public String actualizarData(@PathVariable Long id,@ModelAttribute("data") Data data, Model modelo ) {

			// Recupera los datos existentes desde el servicio
			Data dataExistente=servicio.obtenerDataPorId(id);

			 // Actualiza los atributos de los datos
			dataExistente.setId(id);
			dataExistente.setIndicador_code(data.getIndicador_code());
			dataExistente.setCountry_code(data.getCountry_code());
			dataExistente.setYear(data.getYear());
		    
		    	// Actualiza los datos utilizando el servicio
		    	servicio.actualizarData(dataExistente);
			
			return "redirect:/datas";// Redirige a "/datas"
		}

		// Maneja la solicitud GET para "/datas/{id}"
		@GetMapping({"/datas/{id}"})
		public String eliminarData(@PathVariable Long id) {
			
			servicio.eliminarData(id);
			return "redirect:/datas";
		}
		
	

}
