package com.appwbd.sraeu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaI")
    private Date fechaI;
    @Column(name = "fechaF")
    private Date fechaF;
    @Column(name = "cupo")
    private int cupo;

    @ToString.Exclude
    @ManyToMany(mappedBy = "eventos")
    private List<Asistente> asistentes;

    @ManyToOne
    @JoinColumn
    private Lugar lugar;

    public Evento(String nombre, Date fechaI, Date fechaF, int cupo) {
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.cupo = cupo;

    }

    public Evento(){

    }
}
