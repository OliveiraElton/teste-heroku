package br.com.gerenciaevento.gerenciaevento.controller;

import javax.validation.Valid;

import br.com.gerenciaevento.gerenciaevento.model.Pessoa;
import br.com.gerenciaevento.gerenciaevento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pessoas/")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Pessoa pessoa){
        return "add-pessoa";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model){
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "index-pessoa";
    }

    @PostMapping("add")
    public String addPessoas(@Valid Pessoa pessoa, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-pessoa";
        }

        pessoaRepository.save(pessoa);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido pessoa Id:" + id));
        model.addAttribute("pessoa", pessoa);
        return "update-pessoa";
    }

    @PostMapping("update/{id}")
    public String updatePessoa(@PathVariable("id") long id, @Valid Pessoa pessoa, BindingResult result, Model model){
        if(result.hasErrors()){
            pessoa.setId(id);
            return "update-pessoa";
        }

        pessoaRepository.save(pessoa);
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "index-pessoa";
    }

    @GetMapping("delete/{id}")
    public String deletePessoa(@PathVariable("id") long id, Model model){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido pessoa id:" + id));
            pessoaRepository.delete(pessoa);
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "index-pessoa";
    }

}
