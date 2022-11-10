package com.university.app.controladores;

import com.university.app.servicios.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericController<E, S extends GenericService<E>> {

    protected final S service;

    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){

        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty()){
            //throw new BadRequestException(String.format("No se han econtrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje",String.format("No existen %ss ", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", listado);
        return ResponseEntity.ok(mensaje);
    }
}
