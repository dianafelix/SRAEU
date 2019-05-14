package com.appwbd.sraeu.services;


import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.EventoModel;

import java.util.List;

public interface EventoService{
    public abstract EventoModel addEvento(EventoModel eventoModel) throws Exception;

    public abstract List<EventoModel> listAllEventos();

    public abstract Evento findEventoById(int id);

    public abstract void removeEvento(int id);

    public abstract EventoModel findEventoByIdModel(int id);
}
