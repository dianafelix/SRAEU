package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.services.LugarService;
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

    public Evento convertEventoToModel2Evento(EventoModel eventoModel)throws Exception {
        String fecha = eventoModel.getFechaF();
        Date fech = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        String fecha1 = eventoModel.getFechaI();
        Date fech1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Evento evento = new Evento();

        evento.setId(eventoModel.getId());
        evento.setCupo(eventoModel.getCupo());
        evento.setNombre(eventoModel.getNombre());
        evento.setFechaI(fech);
        evento.setFechaF(fech1);
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
    eventoModel.setFechaF(evento.getFechaF().toString());
    eventoModel.setFechaI(evento.getFechaI().toString());
/*    eventoModel.setLugar(evento.getLugar().getId());
    eventoModel.setLugar(evento.getLugar().getNombre());
    eventoModel.setAsistentes(evento.getAsistentes());*/
    return eventoModel;
    }
}
