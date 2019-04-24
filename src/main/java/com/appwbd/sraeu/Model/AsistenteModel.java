package com.appwbd.sraeu.Model;

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
}
