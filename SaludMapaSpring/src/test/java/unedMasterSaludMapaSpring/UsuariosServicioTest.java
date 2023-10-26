import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito;
import unedMasterSaludMapaSpring.dto.UsuariosRegistroDTO;
import unedMasterSaludMapaSpring.entidad.Roles;
import unedMasterSaludMapaSpring.entidad.Usuarios;
import unedMasterSaludMapaSpring.repositorio.UsuariosRepositorio;
import unedMasterSaludMapaSpring.servicio.UsuariosServicio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuariosServicioTest {

    @Autowired
    private UsuariosServicio usuariosServicio;

    @MockBean
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testSave() {
        // Arrange
        UsuariosRegistroDTO registroDTO = new UsuariosRegistroDTO("testuser", "testpassword");

        when(usuariosRepositorio.save(Mockito.any(Usuarios.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Usuarios result = usuariosServicio.save(registroDTO);

        // Assert
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertTrue(passwordEncoder.matches("testpassword", result.getPassword()));
    }

    @Test
    public void testLoadUserByUsername_ValidUsername() {
        // Arrange
        String username = "testuser";
        Usuarios testUser = new Usuarios(1, username, passwordEncoder.encode("testpassword"), Arrays.asList(new Roles("ROLE_USER")));

        when(usuariosRepositorio.findByUsername(username)).thenReturn(testUser);

        // Act
        UserDetails userDetails = usuariosServicio.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
    }

    @Test
    public void testLoadUserByUsername_InvalidUsername() {
        // Arrange
        String username = "nonexistentuser";

        when(usuariosRepositorio.findByUsername(username)).thenReturn(null);

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> usuariosServicio.loadUserByUsername(username));
    }

    @Test
    public void testGetAll() {
        // Arrange
        Usuarios user1 = new Usuarios(1, "user1", passwordEncoder.encode("password1"), Arrays.asList(new Roles("ROLE_USER")));
        Usuarios user2 = new Usuarios(2, "user2", passwordEncoder.encode("password2"), Arrays.asList(new Roles("ROLE_USER")));
        List<Usuarios> users = new ArrayList<>(Arrays.asList(user1, user2));

        when(usuariosRepositorio.findAll()).thenReturn(users);

        // Act
        List<Usuarios> result = usuariosServicio.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getUsername());
        assertEquals("user2", result.get(1).getUsername());
    }
}
