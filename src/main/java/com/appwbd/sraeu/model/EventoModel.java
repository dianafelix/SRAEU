package com.appwbd.sraeu.model;

import lombok.Data;

@Data
public class EventoModel {

    private int Id;
    private String nombre;
    private String fechaF;
    private String fechaI;
    private String lugar;
    private int cupo;

    public EventoModel(){

    }
}
