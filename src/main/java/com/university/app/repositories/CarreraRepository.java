package com.university.app.repositories;

import com.university.app.entity.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

}
