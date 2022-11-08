package com.university.app;

import com.university.app.entity.Carrera;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraCommands implements CommandLineRunner {

    @Autowired
    private CarreraService carreraService;


    @Override
    public void run(String... args) throws Exception {
    //   Carrera ingSistemas = new Carrera(null, "Ingenieria de Sistemas", 50, 5);
      //  Carrera save = carreraService.save(ingSistemas);
        //System.out.println(save.toString());

    }

}
