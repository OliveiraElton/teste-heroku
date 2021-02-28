package br.com.gerenciaevento.gerenciaevento;

import br.com.gerenciaevento.gerenciaevento.controller.EspacoCafeController;
import br.com.gerenciaevento.gerenciaevento.controller.PessoaController;
import br.com.gerenciaevento.gerenciaevento.model.EspacoCafe;
import br.com.gerenciaevento.gerenciaevento.repository.EspacoCafeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EspacoCafeController.class)
public class EspacoCafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EspacoCafeRepository espacoCafeRepository;

    @Test
    public void findAllEspacos() throws Exception{
        EspacoCafe espacoCafe = new EspacoCafe("teste", 25);
        List<EspacoCafe> espacoList = List.of(espacoCafe);
        when(espacoCafeRepository.findAll()).thenReturn(espacoList);
        this.mockMvc.perform(get("/espacos/list"))
                .andExpect((status().isOk()))
                .andExpect(content().string(containsString("teste")));

    }
}
