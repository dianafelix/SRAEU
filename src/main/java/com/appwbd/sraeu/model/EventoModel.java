package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.Asistente;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class EventoModel {

    private int id;
    private String nombre;
    private String fechaF;
    private String fechaI;
    private int lugar_id;
    private String lugar_nombre;
    private int cupo;
    private List<String> asistentes;


    public EventoModel(){

    }
}
