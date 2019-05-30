package com.appwbd.sraeu.services;


import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.AsistenciaModel;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.model.EventoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("asistenciaService")
public interface AsistenciaService {

    public abstract AsistenteModel addAsistencia(AsistenciaModel asistenciaModel);

}
