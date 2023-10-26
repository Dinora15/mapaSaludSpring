package unedMasterSaludMapaSpring.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {
	// Bean para configurar el codificador de contraseñas BCrypt
	  @Bean
	   public BCryptPasswordEncoder passwordEncoder() {

	      return new BCryptPasswordEncoder();
	   }
	// Configuración de seguridad para las solicitudes HTTP
	  @Bean
	   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      http
	              .authorizeHttpRequests((requests) -> requests
	                      .requestMatchers("/registro**",
	                    		  "/js/**").permitAll()
	                      .requestMatchers("/countries/editar/**", "/countries/nuevo").hasAnyRole("ADMIN")
	                      .requestMatchers("/indicadores/nuevo" , "/indicadores/editar/**").hasAnyRole("ADMIN")
	                      .requestMatchers("/datas/nuevo" , "/datas/editar/**").hasAnyRole("ADMIN")
	                      .anyRequest().authenticated()
	              )
	              .formLogin((form) -> form
	                      .loginPage("/login")
	                      .permitAll()
	              )
	              .logout((logout) -> logout
	                      .logoutUrl("/logout")
	                      .logoutSuccessUrl("/")
	                      .invalidateHttpSession(true));

	      return http.build();
	   }

}
