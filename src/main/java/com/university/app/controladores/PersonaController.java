package com.university.app.controladores;

import com.university.app.entity.Persona;
import com.university.app.exception.BadRequestException;
import com.university.app.servicios.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaService> {


    public PersonaController(PersonaService service) {
        super(service);
    }

    @GetMapping("/nombre-apelliddo")
    public Persona buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if (!oPersona.isPresent()){
            throw new BadRequestException(String.format("No se encontro PErsona con nombre %s y apellido %s", nombre, apellido));
        }
        return oPersona.get();
    }


}
