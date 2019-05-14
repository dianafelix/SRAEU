package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.component.EventoConverter;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.repository.EventoRepository;
import com.appwbd.sraeu.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("eventoServiceImpl")
public class EventoServiceImpl implements EventoService {

    @Autowired
    @Qualifier("eventoRepository")
    private EventoRepository eventoRepository;

    @Autowired
    @Qualifier("eventoConverter")
    private EventoConverter eventoConverter;

    @Override
    public EventoModel addEvento(EventoModel eventoModel) throws Exception {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el eventoModel a entidad
        Evento temp=eventoConverter.convertEventoToModel2Evento(eventoModel);
        Evento evento = eventoRepository.save(temp);
        return eventoConverter.convertEvento2EventoModel(evento);
    }

    @Override
    public List<EventoModel> listAllEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        List<EventoModel> eventosModel = new ArrayList();
        for(Evento evento : eventos){
            eventosModel.add(eventoConverter.convertEvento2EventoModel(evento));

        }
        return eventosModel;
    }

    @Override
    public Evento findEventoById(int id) {
        return eventoRepository.findById(id);
    }

    public EventoModel findEventoByIdModel(int id){
        return eventoConverter.convertEvento2EventoModel(findEventoById(id));
    }

    @Override
    public void removeEvento(int id) {
        Evento evento  = findEventoById(id);
        if(evento != null){
            eventoRepository.delete(findEventoById(id));
        }
    }
}