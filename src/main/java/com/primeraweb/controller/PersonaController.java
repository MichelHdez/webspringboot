package com.primeraweb.controller;

import com.primeraweb.model.Persona;
import com.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listaPersonas(Model model){
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("personas", personas);
        return "listar";
    }

    @GetMapping(value = "/nueva")
    public String nuevaPersona(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    @PostMapping(value = "/nueva")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFomularioEditarPersona(@PathVariable Long id,@ModelAttribute Persona persona,Model model){
        model.addAttribute("persona",persona);
        model.addAttribute("accion","/personas/editar/"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id,@ModelAttribute Persona persona){
        personaService.actualizarPersona(id,persona);
        return "redirect:/personas";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
