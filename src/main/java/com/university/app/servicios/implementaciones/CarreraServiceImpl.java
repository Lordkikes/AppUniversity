package com.university.app.servicios.implementaciones;

import com.university.app.entity.Carrera;
import com.university.app.repositories.CarreraRepository;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> findById(Integer id) {
        return carreraRepository.findById(id);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        carreraRepository.deleteById(id);
    }
}
