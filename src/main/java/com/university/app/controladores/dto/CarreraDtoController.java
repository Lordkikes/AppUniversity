package com.university.app.controladores.dto;

import com.university.app.dto.CarreraDTO;
import com.university.app.entity.Carrera;
import com.university.app.mapper.CarreraMapper;
import com.university.app.mapper.CarreraMapperI;
import com.university.app.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
public class CarreraDtoController {

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private CarreraMapperI carreraMapperI;

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();

        List<Carrera> carreras = (List<Carrera>) carreraService.findAll();

        List<CarreraDTO> carrerasDTOs = carreras
                .stream()
                .map(carreraMapperI::mapCarrera)
                .collect(Collectors.toList());

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", carrerasDTOs);

        return ResponseEntity.ok().body(mensaje);

    }

}
