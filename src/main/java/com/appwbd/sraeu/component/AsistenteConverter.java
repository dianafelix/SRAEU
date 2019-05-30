package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("asistenteConverter")
public class AsistenteConverter {

    @Autowired
    @Qualifier("eventoServiceImpl")
    private EventoService eventoService;

     public Asistente convertAsistenteModel2Asistente(AsistenteModel asistenteModel) {
        Asistente asistente = new Asistente();
        List<Evento> eventos = new ArrayList<>();
        asistente.setId(asistenteModel.getId());
        asistente.setMat(asistenteModel.getMat());
        asistente.setNombre(asistenteModel.getNombre());
        asistente.setApellido(asistenteModel.getApellido());
        asistente.setCorreo(asistenteModel.getCorreo());
        asistente.setTelefono(asistenteModel.getTelefono());
        asistente.setTipo(asistenteModel.getTipo());
        for (EventoModel eventoModel : asistenteModel.getEventos()){

            try {
                eventos.add(eventoService.convertEventoModel2Evento(eventoModel));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        asistente.setEventos(eventos);
        return asistente;
    }

    public AsistenteModel convertAsistente2AsistenteModel(Asistente asistente){
        AsistenteModel asistenteModel = new AsistenteModel();
        List<EventoModel> eventoModels = new ArrayList();
        asistenteModel.setId(asistente.getId());
        asistenteModel.setMat(asistente.getMat());
        asistenteModel.setNombre(asistente.getNombre());
        asistenteModel.setApellido(asistente.getApellido());
        asistenteModel.setCorreo(asistente.getCorreo());
        asistenteModel.setTelefono(asistente.getTelefono());
        asistenteModel.setTipo(asistente.getTipo());
        for(Evento evento : asistente.getEventos()){
            eventoModels.add(eventoService.convertEvento2EventoModel(evento));
        }

        asistenteModel.setEventos(eventoModels);

        return asistenteModel;
    }
}
