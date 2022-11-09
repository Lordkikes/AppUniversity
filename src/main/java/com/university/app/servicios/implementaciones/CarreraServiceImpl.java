package com.university.app.servicios.implementaciones;

import com.university.app.entity.Carrera;
import com.university.app.repositories.CarreraRepository;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServiceImpl extends GenericServiceImpl<Carrera, CarreraRepository> implements CarreraService {

    @Autowired
    public CarreraServiceImpl(CarreraRepository repositroy) {
        super(repositroy);
    }
}
