package com.appwbd.sraeu.entity;

import lombok.Data;
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
    @Column(name="lugar")
    private String lugar;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "evento_lugar",
            joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lugar_id", referencedColumnName = "id"))*/

/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lugar")
    private List<Lugar> lugares;

*/
    public Evento(String nombre, Date fechaI, Date fechaF, int cupo, String lugar) {
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.cupo = cupo;
        this.lugar = lugar;

    }

    public Evento(){

    }
}
