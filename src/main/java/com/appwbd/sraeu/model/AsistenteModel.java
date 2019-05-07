package com.appwbd.sraeu.model;

import lombok.Data;

@Data
public class AsistenteModel {

    private int Id;
    private String nombre;
    private String Apellido;
    private String correo;
    private String telefono;
    private String lugar;
    private String tipo;

    public AsistenteModel(){

    }

    public AsistenteModel(int id, String nombre, String apellido, String correo, String telefono, String lugar, String tipo) {
        Id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.lugar = lugar;
        this.tipo = tipo;
    }
}
