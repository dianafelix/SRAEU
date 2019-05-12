package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.component.AsistenteConverter;
import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.repository.AsistenteRepository;
import com.appwbd.sraeu.services.AsistenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("asistenteServiceImpl")
public class AsistenteServiceImpl implements AsistenteService {

    @Autowired
    @Qualifier("asistenteRepository")
    private AsistenteRepository asistenteRepository;

    @Autowired
    @Qualifier("asistenteConverter")
    private AsistenteConverter asistenteConverter;

    @Override
    public AsistenteModel addAsistente(AsistenteModel asistenteModel){
        Asistente temp = asistenteConverter.convertAsistenteModel2Asistente(asistenteModel);
        Asistente asistente = asistenteRepository.save(temp);

        return asistenteConverter.convertAsistente2AsistenteModel(asistente);
    }

    @Override
    public List<AsistenteModel> listAllAsistentes() {
        List<Asistente> asistentes = asistenteRepository.findAll();
        List<AsistenteModel> asistentesModel = new ArrayList();

        for(Asistente asistente : asistentes)
            asistentesModel.add(asistenteConverter.convertAsistente2AsistenteModel(asistente));

        return asistentesModel;
    }

    @Override
    public Asistente findAsistenteById(int id) {
        return asistenteRepository.findById(id);
    }

    @Override
    public AsistenteModel findAsistenteByIdModel(int i) {
        return asistenteConverter.convertAsistente2AsistenteModel(findAsistenteById(i));
    }

    @Override
    public void removeAsistente(int id) {
        Asistente asistente = findAsistenteById(id);
        if(asistente != null)
            asistenteRepository.delete(findAsistenteById(id));
    }
}
