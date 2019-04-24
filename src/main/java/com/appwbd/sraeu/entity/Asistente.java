package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="asistente")
public class Asistente {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="lugar")
    private String lugar;
    @Column(name="tipo")
    private String tipo;



    public Asistente(int id, String nombre,String apellido, String correo, String telefono, String lugar, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.lugar = lugar;
        this.tipo = tipo;

    }

    public Asistente(){

    }
}



