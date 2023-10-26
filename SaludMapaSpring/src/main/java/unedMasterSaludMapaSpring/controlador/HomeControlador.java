package unedMasterSaludMapaSpring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlador {

	// Maneja la solicitud GET para "/login"
	@GetMapping("/login")
		public String login() {
		return "login";
		}
	// Maneja la solicitud GET para "/"
	@GetMapping("/")
		public String home() {
		return "index";
		}

}
