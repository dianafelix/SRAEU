package com.appwbd.sraeu.Component;

import com.appwbd.sraeu.Model.EventoModel;
import com.appwbd.sraeu.entity.Evento;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("eventoConverter")
public class EventoConverter {

    Evento convertEventoToModel2Evento(EventoModel eventoModel)throws Exception {
        String fecha = eventoModel.getFechaF();
        Date fech = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        String fecha1 = eventoModel.getFechaI();
        Date fech1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Evento evento = new Evento();

        evento.setId(eventoModel.getId());
        evento.setCupo(eventoModel.getCupo());
        evento.setLugar(eventoModel.getLugar());
        evento.setNombre(eventoModel.getNombre());
        evento.setFechaI(fech);
        evento.setFechaF(fech1);
        return evento;
    }

    public EventoModel convertEvento2EventoModel(Evento evento) {
    EventoModel eventoModel = new EventoModel();
    eventoModel.setId(evento.getId());
    eventoModel.setCupo(evento.getCupo());
    eventoModel.setLugar(evento.getLugar());
    eventoModel.setFechaF(evento.getFechaF().toString());
    eventoModel.setFechaI(evento.getFechaI().toString());

    return eventoModel;
    }
}
