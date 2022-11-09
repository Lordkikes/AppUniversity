package com.university.app.servicios.implementaciones;

import com.university.app.servicios.GenericService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericServiceImpl<E, R extends CrudRepository<E, Integer>> implements GenericService<E> {

    protected final R repositroy ;

    public GenericServiceImpl(R repositroy) {
        this.repositroy = repositroy;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repositroy.findById(id);
    }

    @Override
    @Transactional
    public E save(E entidad) {
        return repositroy.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repositroy.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repositroy.deleteById(id);
    }
}
