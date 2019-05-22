package com.appwbd.sraeu.component;

import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.entity.Asistente;
import org.springframework.stereotype.Component;

@Component("asistenteConverter")
public class AsistenteConverter {

     public Asistente convertAsistenteModel2Asistente(AsistenteModel asistenteModel) {
        Asistente asistente = new Asistente();
        asistente.setId(asistenteModel.getId());
        asistente.setMat(asistenteModel.getMat());
        asistente.setNombre(asistenteModel.getNombre());
        asistente.setApellido(asistenteModel.getApellido());
        asistente.setCorreo(asistenteModel.getCorreo());
        asistente.setTelefono(asistenteModel.getTelefono());
        asistente.setTipo(asistenteModel.getTipo());
        return asistente;
    }

    public AsistenteModel convertAsistente2AsistenteModel(Asistente asistente){
        AsistenteModel asistenteModel = new AsistenteModel();
        asistenteModel.setId(asistente.getId());
        asistenteModel.setMat(asistente.getMat());
        asistenteModel.setNombre(asistente.getNombre());
        asistenteModel.setApellido(asistente.getApellido());
        asistenteModel.setCorreo(asistente.getCorreo());
        asistenteModel.setTelefono(asistente.getTelefono());
        asistenteModel.setTipo(asistente.getTipo());
        return asistenteModel;
    }
}
