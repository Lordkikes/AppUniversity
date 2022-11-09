package com.university.app;

import com.university.app.entity.Alumno;
import com.university.app.entity.Carrera;
import com.university.app.entity.Persona;
import com.university.app.servicios.AlumnoService;
import com.university.app.servicios.CarreraService;
import com.university.app.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoServiceImpl")
    private PersonaService personaService;

    @Autowired
    private CarreraService carreraService;

    @Override
    public void run(String... args) throws Exception {

        /*Optional<Carrera> ingSistemas = carreraService.findById(2);

        Iterable<Persona> alumnos = personaService.findAll();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaService.save(alumno));



        Optional<Persona> alumno_1 = personaService.findById(1);

        System.out.println("\n BUSCAR POR NOMBRE Y APELLIDO \n");
        Optional<Persona> personaNombApel = personaService.buscarPorNombreYApellido(alumno_1.get().getNombre(), alumno_1.get().getApellido());
        System.out.println(personaNombApel.toString());

        System.out.println("\n BUSCAR POR DNI \n");
        Optional<Persona> personaDNI = personaService.buscarPorDNI(alumno_1.get().getDni());
        System.out.println(personaDNI.toString());

        System.out.println("\n BUSCAR POR APELLIDO \n");
        Iterable<Persona> personasApel = personaService.buscarPersonaPorApellido(alumno_1.get().getApellido());
        personasApel.forEach(System.out::println);*/

        //Optional<Persona> alumno_1 = personaService.findById(1);
       // Optional<Carrera> ingSistemas = carreraService.findById(2);

       // Iterable<Persona> alumnosCarrera = ((AlumnoService) personaService).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
       // alumnosCarrera.forEach(System.out::println);


    }
}
