package br.com.gerenciaevento.gerenciaevento.controller;

import br.com.gerenciaevento.gerenciaevento.model.SalaEvento;
import br.com.gerenciaevento.gerenciaevento.repository.SalaEventoRepository;
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
@RequestMapping("/salas/")
public class SalaEventoController {

    private final SalaEventoRepository salaEventoRepository;

    @Autowired
    public SalaEventoController(SalaEventoRepository salaEventoRepository) {
        this.salaEventoRepository = salaEventoRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(SalaEvento salaEvento) {
        return "add-sala";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("salas", salaEventoRepository.findAll());
        return "index-sala";
    }

    @PostMapping("add")
    public String addSalas(@Valid SalaEvento salaEvento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-sala";
        }

        salaEventoRepository.save(salaEvento);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        SalaEvento salaEvento = salaEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido sala Id:" + id));
        model.addAttribute("salaEvento", salaEvento);
        return "update-sala";
    }

    @PostMapping("update/{id}")
    public String updateSalas(@PathVariable("id") long id, @Valid SalaEvento salaEvento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            salaEvento.setId(id);
            return "update-sala";
        }

        salaEventoRepository.save(salaEvento);
        model.addAttribute("salas", salaEventoRepository.findAll());
        return "index-sala";
    }

    @GetMapping("delete/{id}")
    public String deleteSala(@PathVariable("id") long id, Model model){
        SalaEvento salaEvento = salaEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inválido sala id:" + id));
        salaEventoRepository.delete(salaEvento);
        model.addAttribute("salas", salaEventoRepository.findAll());
        return "index-sala";
    }
}