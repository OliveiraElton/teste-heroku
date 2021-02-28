package br.com.gerenciaevento.gerenciaevento;

import br.com.gerenciaevento.gerenciaevento.controller.PessoaController;
import br.com.gerenciaevento.gerenciaevento.model.Pessoa;
import br.com.gerenciaevento.gerenciaevento.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaRepository pessoaRepository;

    @Test
    public void findAllPessoas() throws Exception{
        Pessoa pessoa = new Pessoa("teste", "Oliveira", "elton@", "Marte", "Sol");
        List<Pessoa> pessoaList = List.of(pessoa);
        when(pessoaRepository.findAll()).thenReturn(pessoaList);
        this.mockMvc.perform(get("/pessoas/list"))
                .andExpect((status().isOk()))
                .andExpect(content().string(containsString("Oliveira")));

    }
}
