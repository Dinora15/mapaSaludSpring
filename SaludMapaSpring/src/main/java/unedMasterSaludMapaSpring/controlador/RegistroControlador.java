package unedMasterSaludMapaSpring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unedMasterSaludMapaSpring.servicio.UsuariosServicio;
import unedMasterSaludMapaSpring.dto.*;

@Controller
@RequestMapping("/registro")
public class RegistroControlador {

	private UsuariosServicio servicio;
@Autowired
	public RegistroControlador(UsuariosServicio servicio) {
		super();
		this.servicio = servicio;
	}
	
@ModelAttribute("usuario")
public UsuariosRegistroDTO  UsuariosRegistroDTO() {
   return new UsuariosRegistroDTO();
}

@GetMapping
public String mostrarFormularioRegistro() {
   return "registro";
}

@PostMapping
public String registroCuentaUsuario(@ModelAttribute("usuario") 
               UsuariosRegistroDTO registroDTO) {

   try {
     servicio.save(registroDTO);
   }catch(Exception e)
   {
      System.out.println(e);
      return "redirect:/registro?username_invalido";
   }
   return "redirect:/registro?exitoso";
}

}
