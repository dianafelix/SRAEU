package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.AsistenciaModel;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.services.AsistenciaService;
import com.appwbd.sraeu.services.AsistenteService;
import com.appwbd.sraeu.services.EventoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    @Qualifier("asistenteServiceImpl")
    private AsistenteService asistenteService;

    @Autowired
    @Qualifier("eventoServiceImpl")
    private EventoService eventoService;

    @Autowired
    @Qualifier("asistenciaServiceImpl")
    private AsistenciaService asistenciaService;

    private static final Log log = LogFactory.getLog(AsistenciaController.class);


    @GetMapping("/asistenciaForm/{evento}")
    public String redirecAsistenteForm(Model model, @PathVariable("evento")int evento){
        EventoModel eventoModel = eventoService.findEventoByIdModel(evento);

        AsistenciaModel asistenciaModel = new AsistenciaModel();
        asistenciaModel.setEvento_Id(evento);
        asistenciaModel.setAsistente_Id(0);
        model.addAttribute("eventoModel", eventoModel);
        model.addAttribute("asistenciaModel",asistenciaModel);
        model.addAttribute("found", true);

        return ViewConstant.ASISTENCIA_FORM;
    }

    @GetMapping("/quagga")
    public String redirectQuagga(){
        return "PruebaQuagga";
    }

    @PostMapping("/takeAsistencia")
    public String addAsistencia(@ModelAttribute(name = "asistenciaModel") AsistenciaModel asistenciaModel, Model model) throws Exception {
        log.info("Method: addAsistencia() -- Params: " + asistenciaModel.toString());

        asistenciaService.addAsistencia(asistenciaModel);

        return "redirect:/eventos/calendario";
    }

    @GetMapping("/asistenciaForm/{evento}/{mat}")
    public String findAsistente(Model model,@PathVariable("evento")int evento,@PathVariable("mat")int mat){
        AsistenciaModel asistenciaModel = new AsistenciaModel();
        AsistenteModel asistenteModel = asistenteService.findAsistenteByMatriculaModel(mat);
        EventoModel eventoModel = eventoService.findEventoByIdModel(evento);
        boolean found = false;

        if(asistenteModel != null) {
            asistenciaModel.setAsistente_Id(asistenteModel.getId());
            asistenciaModel.setNombre(asistenteModel.getNombre());
            asistenciaModel.setApellido(asistenteModel.getApellido());
            asistenciaModel.setTelefono(asistenteModel.getTelefono());
            asistenciaModel.setCorreo(asistenteModel.getCorreo());
            asistenciaModel.setTipo(asistenteModel.getTipo());
            found = true;
        }
        asistenciaModel.setEvento_Id(evento);
        asistenciaModel.setMat(mat);

        model.addAttribute("asistenciaModel", asistenciaModel);
        model.addAttribute("eventoModel", eventoModel);
        model.addAttribute("found", found);

        return ViewConstant.ASISTENCIA_FORM;
    }


}
