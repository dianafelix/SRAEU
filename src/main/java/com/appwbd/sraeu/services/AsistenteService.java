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

    public abstract AsistenteModel findAsistenteByMatriculaModel(int matricula);

    public abstract void removeAsistente(int id);

    public abstract  boolean findAsistenteByMat(int mat);

    public abstract Asistente convertAsistenteModel2Asistente(AsistenteModel asistenteModel);

    public abstract AsistenteModel convertAsistente2AsistenteModel(Asistente asistente);
}
