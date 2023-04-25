package com.unialfa.timefutebol.controller;

import com.unialfa.timefutebol.model.Time;
import com.unialfa.timefutebol.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeController {

    @Autowired
    private TimeService service;

    @RequestMapping("/")
    public String iniciar(Time time, Model model){
        model.addAttribute("boasVindas", "UniALFA - Formulário");
        return "formulario";
    }

    @PostMapping("salvar")
    public String salvar(Time time, Model model){
        service.salvarTime(time);
        return "redirect:/lista";
    }

    @GetMapping("lista")
    public String listar(Model model){
        model.addAttribute("boasVindas", "UniALFA - Lista de Clubes");
        model.addAttribute("listaTimes",service.listarTodos());
        return "lista";
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Integer id, Model model){
        model.addAttribute("boasVindas", "UniALFA - Formulário");
        model.addAttribute("time", service.buscarPorId(id));
        return "formulario";
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable Integer id, Time time){
        time = service.buscarPorId(id);
        service.remover(time);

        return "redirect:/lista";
    }

}
