package br.com.gerenciaevento.gerenciaevento.controller;

import br.com.gerenciaevento.gerenciaevento.model.EspacoCafe;
import br.com.gerenciaevento.gerenciaevento.repository.EspacoCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/espacos/")
public class EspacoCafeController {

    private final EspacoCafeRepository espacoCafeRepository;

    @Autowired
    public EspacoCafeController(EspacoCafeRepository espacoCafeRepository) {
        this.espacoCafeRepository = espacoCafeRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(EspacoCafe espacoCafe) {
        return "add-espaco";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("espacos", espacoCafeRepository.findAll());
        return "index-espaco";
    }

    @PostMapping("add")
    public String addEspacos(@Valid EspacoCafe espacoCafe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-espaco";
        }

        espacoCafeRepository.save(espacoCafe);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        EspacoCafe espacoCafe = espacoCafeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido espaço café Id:" + id));
        model.addAttribute("espacoCafe", espacoCafe);
        return "update-espaco";
    }

    @PostMapping("update/{id}")
    public String updateEspacos(@PathVariable("id") long id, @Valid EspacoCafe espacoCafe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            espacoCafe.setId(id);
            return "update-espaco";
        }

        espacoCafeRepository.save(espacoCafe);
        model.addAttribute("espacos", espacoCafeRepository.findAll());
        return "index-espaco";
    }

    @GetMapping("delete/{id}")
    public String deleteEspaco(@PathVariable("id") long id, Model model){
        EspacoCafe espacoCafe = espacoCafeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido espaço café id:" + id));
        espacoCafeRepository.delete(espacoCafe);
        model.addAttribute("espacos", espacoCafeRepository.findAll());
        return "index-espaco";
    }
}
