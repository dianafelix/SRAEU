package com.appwbd.sraeu.Component;

import com.appwbd.sraeu.Model.AsistenteModel;
import com.appwbd.sraeu.entity.Asistente;
import org.springframework.stereotype.Component;

@Component("asistenteConverter")
public class AsistenteConverter {

     Asistente convertAsistenteModel2Asistente(AsistenteModel asistenteModel) {
        Asistente asistente = new Asistente();
        asistente.setId(asistenteModel.getId());
        asistente.setNombre(asistenteModel.getNombre());
        asistente.setApellido(asistenteModel.getApellido());
        asistente.setCorreo(asistenteModel.getCorreo());
        asistente.setLugar(asistenteModel.getLugar());
        asistente.setTelefono(asistenteModel.getTelefono());
        asistente.setTipo(asistenteModel.getTipo());
        return asistente;
    }

    public AsistenteModel convertAsistente2AsistenteModel(Asistente asistente){
        AsistenteModel asistenteModel = new AsistenteModel();
        asistenteModel.setId(asistenteModel.getId());
        asistenteModel.setNombre(asistenteModel.getNombre());
        asistenteModel.setApellido(asistenteModel.getApellido());
        asistenteModel.setCorreo(asistenteModel.getApellido());
        asistenteModel.setLugar(asistenteModel.getLugar());
        asistenteModel.setTelefono(asistenteModel.getTelefono());
        asistenteModel.setTipo(asistenteModel.getTipo());
        return asistenteModel;
    }
}
