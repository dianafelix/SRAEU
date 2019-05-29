package com.appwbd.sraeu.model;

import lombok.Data;

import java.util.List;


@Data
public class LugarModel {

    private int id;
    private String nombre;
    private String direccion;
    private List<LugarModel> lugares;

    public LugarModel(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public LugarModel(){

    }
}