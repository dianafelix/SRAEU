package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.entity.Lugar;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class EventoModel {

    private int id;
    private String nombre;
    private String fechaF;
    private String fechaI;
    private String lugar;
    private int cupo;
    private Set<Asistente> asistentes = new HashSet<Asistente>();


    public EventoModel(){

    }
}
