package com.appwbd.sraeu.services.impl;


import com.appwbd.sraeu.component.AsistenciaConverter;
import com.appwbd.sraeu.component.AsistenteConverter;
import com.appwbd.sraeu.component.EventoConverter;
import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.entity.Evento;
import com.appwbd.sraeu.model.AsistenciaModel;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.repository.AsistenteRepository;
import com.appwbd.sraeu.repository.EventoRepository;
import com.appwbd.sraeu.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("asistenciaServiceImpl")
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    @Qualifier("asistenteRepository")
    private AsistenteRepository asistenteRepository;

    @Autowired
    @Qualifier("asistenteConverter")
    private AsistenteConverter asistenteConverter;

    @Autowired
    @Qualifier("eventoRepository")
    private EventoRepository eventoRepository;

    @Autowired
    @Qualifier("eventoConverter")
    private EventoConverter eventoConverter;

    @Autowired
    @Qualifier("asistenciaConverter")
    private AsistenciaConverter asistenciaConverter;

    @Override
    public AsistenteModel addAsistencia(AsistenciaModel asistenciaModel){
        Asistente temp = asistenciaConverter.convertAsistenciaModel2Asistencia(asistenciaModel);
        Asistente asistente = asistenteRepository.save(temp);
        return asistenteConverter.convertAsistente2AsistenteModel(asistente);
    }





}
