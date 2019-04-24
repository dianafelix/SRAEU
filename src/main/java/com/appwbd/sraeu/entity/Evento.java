package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="evento")
public class Evento {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaI")
    private Date fechaI;
    @Column(name = "fechaF")
    private Date fechaF;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "cupo")
    private int cupo;




    public Evento(int id, String nombre, Date fechaI, Date fechaF, String lugar, int cupo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.lugar = lugar;
        this.cupo = cupo;

    }

    public Evento(){

    }
}
