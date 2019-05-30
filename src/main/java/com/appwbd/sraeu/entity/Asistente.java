package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="asistente")
public class Asistente {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name="matricula",unique = true,nullable = true)
    private Integer mat;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="tipo")
    private String tipo;


    @ManyToMany
    @JoinTable(name = "evento_asistente",
            joinColumns = @JoinColumn(name = "asistente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"))
    private List<Evento> eventos;





    public Asistente(int id, String nombre,String apellido, String correo, String telefono, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;

    }

    public Asistente(){

    }
}



