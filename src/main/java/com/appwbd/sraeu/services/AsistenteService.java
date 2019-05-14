package com.appwbd.sraeu.services;

import com.appwbd.sraeu.entity.Asistente;
import com.appwbd.sraeu.model.AsistenteModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("asistenteService")
public interface AsistenteService {
    public abstract AsistenteModel addAsistente(AsistenteModel asistenteModel);

    public abstract List<AsistenteModel> listAllAsistentes();

    public abstract Asistente findAsistenteById(int id);

    public abstract AsistenteModel findAsistenteByIdModel(int id);

    public abstract void removeAsistente(int id);
}
