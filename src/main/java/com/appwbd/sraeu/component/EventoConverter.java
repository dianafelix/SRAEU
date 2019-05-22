package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.services.LugarService;
import javafx.util.converter.TimeStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        /*Lugar testLugar = new Lugar();
        testLugar.setId(1);
        testLugar.setNombre("AULA MAGNA");
        testLugar.setDireccion("UABC");
        evento.setLugar(testLugar);

        evento.setLugar(lugarService.findLugarById(eventoModel.getLugar()));
        evento.setAsistentes(eventoModel.getAsistentes());*/
        return evento;
    }

    public EventoModel convertEvento2EventoModel(Evento evento) {
    EventoModel eventoModel = new EventoModel();
    eventoModel.setId(evento.getId());
    eventoModel.setCupo(evento.getCupo());
    eventoModel.setNombre(evento.getNombre());
    eventoModel.setFechaF(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(evento.getFechaF()));
    eventoModel.setFechaI(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(evento.getFechaI()));
/*    eventoModel.setLugar(evento.getLugar().getId());
    eventoModel.setLugar(evento.getLugar().getNombre());
    eventoModel.setAsistentes(evento.getAsistentes());*/
    return eventoModel;
    }
}
