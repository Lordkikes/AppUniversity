package com.university.app.model.entity;

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
@Table(name = "pabellones")
public class Pabellon implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "metros_cuadrados")
    private Double mts2;

    @Column(name = "nombre_pabellon", unique = true, nullable = false)
    private String nombrePabellon;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToMany(
            mappedBy = "pabellon",
            fetch = FetchType.LAZY
    )
    private Set<Aula> aulas;

    @PrePersist
    private void antesPersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void despuesPersistir() {
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pabellon)) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombrePabellon.equals(pabellon.nombrePabellon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombrePabellon);
    }
}
