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
    private LugarModel lugar;
    private int cupo;


    public EventoModel(){

    }
}
