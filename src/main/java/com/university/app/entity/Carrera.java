package com.university.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_carrera", nullable = false, unique = true, length = 80)
    @NotNull
    @NotEmpty(message = "Debe ingresar un valor")
    private String nombre;

    @Column(name = "cantidad_materias")
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidadMaterias;

    @Column(name = "cantidad_anios")
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidadAnios;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carrera"})
    private Set<Alumno> alumnos;

    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carreras"})
    private Set<Profesor> profesores;

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    @PrePersist
    private void antesPersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void despuesPersistir(){
        this.fechaModificacion = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrera)) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
