package com.university.app;

import com.university.app.entity.Carrera;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
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

      /*  Carrera carrera = null;

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

       */

       /* Carrera ingSistemas = new Carrera(null, "Ingenieria de Sistemas", 50, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria de Alimentos", 60, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 65, 5);
        Carrera ingQuimica = new Carrera(null, "Ingenieria Quimica", 50, 5);

        carreraService.save(ingSistemas);
        carreraService.save(ingIndustrial);
        carreraService.save(ingAlimentos);
        carreraService.save(ingElectronica);
        carreraService.save(ingQuimica);
        

        List<Carrera> carreras = (List<Carrera>) carreraService.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);

        List<Carrera> carreraIgnoreCase = (List<Carrera>) carreraService.findCarrerasByNombreContainsIgnoreCase("sistemas");
        List<Carrera> carreraIgnoreCase2 = (List<Carrera>) carreraService.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
        carreraIgnoreCase.forEach(System.out::println);
        carreraIgnoreCase2.forEach(System.out::println);


        System.out.println("\t Carreras por cantidad de Años");
        List<Carrera> carrerasPorAnio = (List<Carrera>) carreraService.findCarrerasByCantidadAniosAfter(4);
        carrerasPorAnio.forEach(System.out::println);*/


    }
}
