import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unedMasterSaludMapaSpring.entidad.Indicador;
import unedMasterSaludMapaSpring.repositorio.IndicadorRepositorio;
import unedMasterSaludMapaSpring.servicio.IndicadorServicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IndicadorServicioTest {

    @Autowired
    private IndicadorServicio indicadorServicio;

    @MockBean
    private IndicadorRepositorio indicadorRepositorio;

    @Test
    public void testFindAll() {
        // Arrange
        Pageable pageable = Pageable.unpaged();
        List<Indicador> indicadores = new ArrayList<>();
        indicadores.add(new Indicador(1L, "Indicador1", "Code1", "Nota1", "Organization1"));
        indicadores.add(new Indicador(2L, "Indicador2", "Code2", "Nota2", "Organization2"));
        Page<Indicador> mockPage = Mockito.mock(Page.class);

        when(mockPage.getContent()).thenReturn(indicadores);
        when(indicadorRepositorio.findAll(pageable)).thenReturn(mockPage);

        // Act
        Page<Indicador> result = indicadorServicio.findAll(pageable);

        // Assert
        assertEquals(2, result.getContent().size());
        assertEquals("Indicador1", result.getContent().get(0).getIndicador_name());
        assertEquals("Indicador2", result.getContent().get(1).getIndicador_name());
    }

    @Test
    public void testObtenerIndicadorPorId() {
        // Arrange
        Long id = 1L;
        Indicador mockIndicador = new Indicador(id, "Test Indicador", "Test Code", "Test Nota", "Test Organization");

        when(indicadorRepositorio.findById(id)).thenReturn(Optional.of(mockIndicador));

        // Act
        Indicador result = indicadorServicio.obtenerIndicadorPorId(id);

        // Assert
        assertEquals(id, result.getId());
        assertEquals("Test Indicador", result.getIndicador_name());
        assertEquals("Test Code", result.getIndicador_code());
    }

    @Test
    public void testGuardarIndicador() {
        // Arrange
        Indicador newIndicador = new Indicador(null, "New Indicador", "New Code", "New Nota", "New Organization");
        when(indicadorRepositorio.save(newIndicador)).thenReturn(new Indicador(1L, "New Indicador", "New Code", "New Nota", "New Organization"));

        // Act
        Indicador result = indicadorServicio.guardarIndicador(newIndicador);

        // Assert
        assertEquals(1L, result.getId());
        assertEquals("New Indicador", result.getIndicador_name());
        assertEquals("New Code", result.getIndicador_code());
    }

    @Test
    public void testActualizarIndicador() {
        // Arrange
        Long id = 1L;
        Indicador existingIndicador = new Indicador(id, "Existing Indicador", "Existing Code", "Existing Nota", "Existing Organization");
        Indicador updatedIndicador = new Indicador(id, "Updated Indicador", "Updated Code", "Updated Nota", "Updated Organization");

        when(indicadorRepositorio.findById(id)).thenReturn(Optional.of(existingIndicador));
        when(indicadorRepositorio.save(updatedIndicador)).thenReturn(updatedIndicador);

        // Act
        Indicador result = indicadorServicio.actualizarIndicador(updatedIndicador);

        // Assert
        assertEquals(id, result.getId());
        assertEquals("Updated Indicador", result.getIndicador_name());
        assertEquals("Updated Code", result.getIndicador_code());
    }

    @Test
    public void testEliminarIndicador() {
        // Arrange
        Long id = 1L;

        // Act
        indicadorServicio.eliminarIndicador(id);

        // Assert
        verify(indicadorRepositorio).deleteById(id);
    }
}
