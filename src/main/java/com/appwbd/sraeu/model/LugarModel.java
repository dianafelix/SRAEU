package com.appwbd.sraeu.model;

import lombok.Data;



@Data
public class LugarModel {

    private int id;
    private String nombre;
    private String direccion;

    public LugarModel(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public LugarModel(){

    }
}