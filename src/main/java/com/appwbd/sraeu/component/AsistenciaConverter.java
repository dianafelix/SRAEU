package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.AsistenciaModel;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.repository.AsistenteRepository;
import com.appwbd.sraeu.repository.EventoRepository;
import com.appwbd.sraeu.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

@Component("asistenciaConverter")
public class AsistenciaConverter {

    @Autowired
    @Qualifier("eventoRepository")
    private EventoRepository eventoRepository;


    @Autowired
    @Qualifier("asistenteRepository")
    private AsistenteRepository asistenteRepository;

    public Asistente convertAsistenciaModel2Asistencia(AsistenciaModel asistenciaModel) {


        Evento evento = eventoRepository.findById(asistenciaModel.getEvento_Id());
        Asistente asistente = new Asistente();
        if(asistenciaModel.getAsistente_Id()!=0){
            asistente = asistenteRepository.findById(asistenciaModel.getAsistente_Id());

        }else{
            asistente.setMat(asistenciaModel.getMat());
            asistente.setApellido(asistenciaModel.getApellido());
            asistente.setCorreo(asistenciaModel.getCorreo());
            asistente.setNombre(asistenciaModel.getNombre());
            asistente.setTelefono(asistenciaModel.getTelefono());
            asistente.setTipo(asistenciaModel.getTipo());
            asistente.setEventos(new ArrayList<>());
        }
        asistente.getEventos().add(evento);

        return asistente;

    }


}
