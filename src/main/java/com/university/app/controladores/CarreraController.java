package com.university.app.controladores;

import com.university.app.entity.Carrera;
import com.university.app.exception.BadRequestException;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    private final CarreraService carreraService;


    @Autowired
    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraService.findAll();
        if(carreras.isEmpty()){
            throw new BadRequestException("No existen carreras");
        }
        return carreras;
    }

    @GetMapping("/{id}")
    public Carrera obtenerporId(@PathVariable(value = "id", required = false) Integer id){
        Optional<Carrera> oCarrera = carreraService.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La Carrera con ID %d no existe", id));
        }
        return oCarrera.get();
    }

    @PostMapping("/crearCarrera")
    public Carrera crearCarrera(@RequestBody Carrera nuevaCarrera){
        if(nuevaCarrera.getCantidadAnios() < 0){
            throw new BadRequestException("La cantidad de años no puede ser negativo");
        }
        if(nuevaCarrera.getCantidadMaterias() < 0){
            throw new BadRequestException("La cantidad de materias no puede ser negativo");
        }
        return carreraService.save(nuevaCarrera);
    }

    @PutMapping("/updateCarrera/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = carreraService.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La Carrera con ID %d no existe", id));
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        return carreraService.save(carreraUpdate);

    }

    @DeleteMapping("/deleteCarrera/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        carreraService.deleteById(id);
    }


}
