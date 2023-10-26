import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DataControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testObtenerTodos() throws Exception {
        mockMvc.perform(get("/datas"))
               .andExpect(status().isOk())
               .andExpect(view().name("datas"))
               .andExpect(model().attributeExists("page", "pageNumbers"))
               .andDo(print());
    }

    @Test
    public void testMostrarFormularioDeRegistrarData() throws Exception {
        mockMvc.perform(get("/datas/nuevo"))
               .andExpect(status().isOk())
               .andExpect(view().name("crear_data"))
               .andExpect(model().attributeExists("data"))
               .andDo(print());
    }

    @Test
    public void testGuardarData() throws Exception {
        mockMvc.perform(post("/datas")
                .param("indicador_code", "TestCode")
                .param("country_code", "TestCountryCode")
                .param("year", "2023"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/datas"))
               .andDo(print());
    }

    @Test
    public void testMostrarFormularioDeEditar() throws Exception {
        mockMvc.perform(get("/datas/editar/1")) // Replace '1' with a valid data ID
               .andExpect(status().isOk())
               .andExpect(view().name("editar_data"))
               .andExpect(model().attributeExists("data"))
               .andDo(print());
    }

    @Test
    public void testActualizarData() throws Exception {
        mockMvc.perform(post("/datas/{id}", 1) // Replace '1' with a valid data ID
                .param("indicador_code", "UpdatedCode")
                .param("country_code", "UpdatedCountryCode")
                .param("year", "2023"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/datas"))
               .andDo(print());
    }

    @Test
    public void testEliminarData() throws Exception {
        mockMvc.perform(get("/datas/{id}/delete", 1)) // Replace '1' with a valid data ID
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/datas"))
               .andDo(print());
    }
}
