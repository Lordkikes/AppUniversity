package com.university.app.controladores;

import com.university.app.exception.BadRequestException;
import com.university.app.servicios.GenericService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController<E, S extends GenericService<E>> {

    protected final S service;

    protected String nombreEntidad;


    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty())
            throw new BadRequestException(String.format("No se han econtrado %ss", nombreEntidad));
        return listado;
    }
}
