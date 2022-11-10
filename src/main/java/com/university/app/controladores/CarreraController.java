package com.university.app.controladores;

import com.university.app.entity.Carrera;
import com.university.app.exception.BadRequestException;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController extends GenericController<Carrera, CarreraService>{

    @Autowired
    public CarreraController(CarreraService service) {
        super(service);
        nombreEntidad = "Carrera";
    }

   /* @GetMapping("/{id}")
    public Carrera obtenerporId(@PathVariable(value = "id", required = false) Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La Carrera con ID %d no existe", id));
        }
        return oCarrera.get();
    }

    */

    @PostMapping("/crearCarrera")
    public ResponseEntity<?> crearCarrera(@Valid @RequestBody Carrera nuevaCarrera, BindingResult result){
       /* if(nuevaCarrera.getCantidadAnios() < 0){
            throw new BadRequestException("La cantidad de años no puede ser negativo");
        }
        if(nuevaCarrera.getCantidadMaterias() < 0){
            throw new BadRequestException("La cantidad de materias no puede ser negativo");
        }
        */
        Map<String, Object> validaciones = new HashMap<>();

        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }

        return ResponseEntity.ok(service.save(nuevaCarrera));
    }


    @PutMapping("/updateCarrera/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String, Object> mensaje = new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);

        if(!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("La Carrera con ID %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje",String.format("%s con ID %d no existe ", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);

    }

  /*  @DeleteMapping("/deleteCarrera/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }

   */

}
