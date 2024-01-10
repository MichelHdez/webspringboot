package com.primeraweb;

import com.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebspringbootApplication{

    @Autowired
    private PersonaService personaService;

    public static void main(String[] args) {
        SpringApplication.run(WebspringbootApplication.class, args);

    }

    /*@Override
    public void run(String... args) throws Exception {
        personaService.crearPersona(new Persona(1L, "Jose", 17));
        personaService.crearPersona(new Persona(2L, "Sara", 22));
        personaService.crearPersona(new Persona(3L, "David", 18));
        personaService.crearPersona(new Persona(4L, "Ana", 20));

        //Mostramos el número de Personas
        System.out.println("Número de personas en la BD" + personaService.contarPersonas());

        //Mostramos la lista de Personas
        List<Persona> personas = personaService.obtenerTodas();
        personas.forEach(persona -> System.out.println("Persona: " + persona.getNombre() + " " + persona.getEdad()));
    }*/
}
