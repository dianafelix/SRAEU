package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="lugar")
public class Lugar {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "lugar_evento",
            joinColumns = @JoinColumn(name = "lugar_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"))
    private Set<Evento> eventos;


    public Lugar(int id, String nombre ) {
        this.id = id;
        this.nombre = nombre;
    }

    public Lugar(){

    }
}

