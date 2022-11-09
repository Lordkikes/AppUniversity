package com.university.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String nombreCarrera;

    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    private Set<Alumno> alumnos;

    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    private Set<Profesor> profesores;

    public Carrera(Integer id, String nombreCarrera, Integer cantidadMaterias, Integer cantidadAnios) {
        this.id = id;
        this.nombreCarrera = nombreCarrera;
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
                ", nombreCarrera='" + nombreCarrera + '\'' +
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
        return id.equals(carrera.id) && nombreCarrera.equals(carrera.nombreCarrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCarrera);
    }
}
