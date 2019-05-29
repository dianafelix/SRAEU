package com.appwbd.sraeu.entity;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "evento_asistente",
            joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "asistente_id", referencedColumnName = "id"))
    private Set<Asistente> asistentes;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "lugar_evento",
            joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lugar_id", referencedColumnName = "id"))
    private List<Lugar> lugares;

    public Evento(String nombre, Date fechaI, Date fechaF, int cupo) {
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.cupo = cupo;

    }

    public Evento(){

    }
}
