package com.university.app.servicios.implementaciones;

import com.university.app.entity.Carrera;
import com.university.app.repositories.CarreraRepository;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, CarreraRepository> implements CarreraService {

    @Autowired
    public CarreraServiceImpl(CarreraRepository repositroy) {
        super(repositroy);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repositroy.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repositroy.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repositroy.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return repositroy.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }
}
