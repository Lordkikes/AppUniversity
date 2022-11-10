package com.university.app.controladores;

import com.university.app.entity.Persona;
import com.university.app.servicios.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaService> {

    public PersonaController(PersonaService service) {
        super(service);
    }

    @GetMapping("/nombre-apelliddo")
    public ResponseEntity<?> buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){

        Map<String, Object> mensaje = new HashMap<>();

        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if (!oPersona.isPresent()){
            //throw new BadRequestException(String.format("No se encontro PErsona con nombre %s y apellido %s", nombre, apellido));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontro Persona con Nombre %s y apellido %s", nombre, apellido));
            return  ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oPersona.get());
        return ResponseEntity.ok(mensaje);
    }


}
