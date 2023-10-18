package unedMasterSaludMapaSpring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlador {
	  @GetMapping("/login")
	   public String login() {
	      return "login";
	   }

	   @GetMapping("/")
	   public String home() {
	      return "index";
}

}
