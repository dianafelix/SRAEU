package com.appwbd.sraeu.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy = "lugar")
    private List<Evento> eventos;


    public Lugar(int id, String nombre, String direccion ) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Lugar(){

    }
}

