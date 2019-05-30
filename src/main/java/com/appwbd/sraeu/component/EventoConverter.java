package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.LugarModel;
import com.appwbd.sraeu.services.LugarService;
import javafx.util.converter.TimeStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("eventoConverter")
public class EventoConverter {

    @Autowired
    @Qualifier("lugarServiceImpl")
    private LugarService lugarService;

    public Evento convertEventoModel2Evento(EventoModel eventoModel)throws Exception {
        String[] fecha = eventoModel.getFechaF().split("T");
        Date fech = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(fecha[0] + " " + fecha[1]);
        String[] fecha1 = eventoModel.getFechaI().split("T");
        Date fech1 = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(fecha1[0] + " " + fecha1[1]);
        Evento evento = new Evento();
        evento.setId(eventoModel.getId());
        evento.setCupo(eventoModel.getCupo());
        evento.setNombre(eventoModel.getNombre());
        evento.setFechaI(fech1);
        evento.setFechaF(fech);
        //evento.setLugar(new Lugar(1,"PRUEBA","PRUEBA"));
        evento.setLugar(lugarService.findLugarById(eventoModel.getLugar_id()));

        return evento;
    }

    public EventoModel convertEvento2EventoModel(Evento evento) {
    EventoModel eventoModel = new EventoModel();
    List<String> asistenteNames= new ArrayList();
    eventoModel.setId(evento.getId());
    eventoModel.setCupo(evento.getCupo());
    eventoModel.setNombre(evento.getNombre());
    eventoModel.setFechaF(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(evento.getFechaF()));
    eventoModel.setFechaI(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(evento.getFechaI()));
    eventoModel.setLugar_id(evento.getLugar().getId());
    eventoModel.setLugar_nombre(evento.getLugar().getNombre());
    for(Asistente asistente : evento.getAsistentes()){
        asistenteNames.add(asistente.getNombre() + " " + asistente.getApellido());
    }
    eventoModel.setAsistentes(asistenteNames);

    return eventoModel;
    }
}
