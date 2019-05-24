package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="lugar")
public class Lugar {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Evento> eventoLugares;


    public Lugar(int id, String nombre, String direccion ) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Lugar(){

    }
}

