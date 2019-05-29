package com.appwbd.sraeu.model;

import lombok.Data;

@Data
public class EventoModel {

    private int id;
    private String nombre;
    private String fechaF;
    private String fechaI;
    private int cupo;
    private String lugar;
    //private List<LugarModel> lugares;
    //private Set<Asistente> asistentes = new HashSet<Asistente>();


    public EventoModel(){

    }
}
