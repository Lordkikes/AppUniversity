package com.university.app;

import com.university.app.entity.Carrera;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarreraCommands implements CommandLineRunner {

    @Autowired
    private CarreraService carreraService;


    @Override
    public void run(String... args) throws Exception {
    //   Carrera ingSistemas = new Carrera(null, "Ingenieria de Sistemas", 50, 5);
      //  Carrera save = carreraService.save(ingSistemas);
        //System.out.println(save.toString());

        Carrera carrera = null;

        Optional<Carrera> oCarrera = carreraService.findById(1);
        if(oCarrera.isPresent()) {
            carrera = oCarrera.get();
            System.out.println(carrera.toString());
        }else {
            System.out.println("Carrera no encontrada");
        }

        carrera.setCantidadMaterias(65);
        carrera.setCantidadAnios(6);

        carreraService.save(carrera);
        System.out.println(carreraService.findById(1).orElse(new Carrera()).toString());

        carreraService.deleteById(1);
        System.out.println(carreraService.findById(1).orElse(new Carrera()).toString());


    }
}
