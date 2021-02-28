package br.com.gerenciaevento.gerenciaevento;

import br.com.gerenciaevento.gerenciaevento.controller.PessoaController;
import br.com.gerenciaevento.gerenciaevento.controller.SalaEventoController;
import br.com.gerenciaevento.gerenciaevento.model.Pessoa;
import br.com.gerenciaevento.gerenciaevento.model.SalaEvento;
import br.com.gerenciaevento.gerenciaevento.repository.PessoaRepository;
import br.com.gerenciaevento.gerenciaevento.repository.SalaEventoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SalaEventoController.class)
public class SalaEventoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalaEventoRepository salaEventoRepository;

    @Test
    public void findAllPessoas() throws Exception{
        SalaEvento salaEvento = new SalaEvento("teste", 25);
        List<SalaEvento> salaEventoList = List.of(salaEvento);
        when(salaEventoRepository.findAll()).thenReturn(salaEventoList);
        this.mockMvc.perform(get("/salas/list"))
                .andExpect((status().isOk()))
                .andExpect(content().string(containsString("teste")));

    }


}
