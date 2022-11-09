package com.university.app.controladores;

import com.university.app.entity.Alumno;
import com.university.app.entity.Carrera;
import com.university.app.entity.Persona;
import com.university.app.exception.BadRequestException;
import com.university.app.servicios.CarreraService;
import com.university.app.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    private final CarreraService carreraService;

    public AlumnoController(@Qualifier("alumnoServiceImpl") PersonaService alumnoService, CarreraService carreraService) {
        super(alumnoService);
        nombreEntidad= "Alumno";
        this.carreraService = carreraService;
    }

  /*  @GetMapping("/all")
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) alumnoService.findAll();
        if (alumnos.isEmpty()){
            throw new BadRequestException("No existen Alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable Integer id){
        Optional<Persona> oAlumno = alumnoService.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe", id));
        }
        return oAlumno.get();
    }

    @PostMapping("/createAlumno")
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoService.save(alumno);
    }

   */

    @PutMapping("/actualizar/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe", id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());

        return service.save(alumnoUpdate);

    }

   /* @DeleteMapping("/eliminarAlumno/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoService.deleteById(id);
    }

    */

    @PutMapping("{idAlumno}/carrera/{idCarrera}")
    public Persona asgnarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe", idAlumno));
        }
        Optional<Carrera> oCarrera = carreraService.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);
        return service.save(alumno);

    }




}
