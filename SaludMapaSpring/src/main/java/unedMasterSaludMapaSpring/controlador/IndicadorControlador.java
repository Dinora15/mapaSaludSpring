package unedMasterSaludMapaSpring.controlador;

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

import unedMasterSaludMapaSpring.entidad.Indicador;
import unedMasterSaludMapaSpring.servicio.IndicadorServicio;

@Controller
public class IndicadorControlador {
	@Autowired
	private IndicadorServicio servicio;
		
		@GetMapping({"/indicadores"})	
		public String obtenerTodos(@PageableDefault( size=2, page=0)Pageable pageable, Model model){		
			
			Page<Indicador> page=servicio.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));		
			
			
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
			 return "indicadores";
		}
		
		
		@GetMapping({"/indicadores/nuevo"})
		public String mostrarFormularioDeRegistrarIndicador(Model modelo) {
			Indicador indicador=new Indicador();
			modelo.addAttribute("indicador", indicador);
			return "crear_indicador";
		}

		@PostMapping("/indicadores")
		public String guardarIndicador(@ModelAttribute("indicador")Indicador indicador)
		{
			servicio.guardarIndicador(indicador);
			return "redirect:/indicadores";
		}

		@GetMapping("/indicadores/editar/{id}")
		public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
			modelo.addAttribute("indicador", servicio.obtenerIndicadorPorId(id));
			return "editar_indicador";
		}

		@PostMapping("/indicadores/{id}")
		public String actualizarIndicador(@PathVariable Long id,@ModelAttribute("indicador") Indicador indicador, Model modelo ) {
			
			Indicador indicadorExistente=servicio.obtenerIndicadorPorId(id);
			
			indicadorExistente.setId(id);
		    indicadorExistente.setIndicador_name(indicador.getIndicador_name());
		    indicadorExistente.setIndicador_code(indicador.getIndicador_code());
		    indicadorExistente.setSource_nota(indicador.getSource_nota());
		    indicadorExistente.setSource_organization(indicador.getSource_organization());
		    
		    servicio.actualizarIndicador(indicadorExistente);
			
			return "redirect:/indicadores";
		}

		@GetMapping({"/indicadores/{id}"})
		public String eliminarIndicador(@PathVariable Long id) {
			
			servicio.eliminarIndicador(id);
			return "redirect:/indicadores";
		}


}
