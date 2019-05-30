package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.AsistenciaModel;
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


    @GetMapping("/asistenciaForm")
    public String redirecAsistenteForm(Model model, @RequestParam(name="evento") int evento){
        EventoModel eventoModel = eventoService.findEventoByIdModel(evento);

        AsistenciaModel asistenciaModel = new AsistenciaModel();
        asistenciaModel.setEvento_Id(evento);
        asistenciaModel.setAsistente_Id(0);
        model.addAttribute("eventoModel", eventoModel);
        model.addAttribute("asistenciaModel",asistenciaModel);

        return ViewConstant.ASISTENCIA_FORM;
    }

    @PostMapping("/takeAsistencia")
    public String addAsistencia(@ModelAttribute(name = "asistenciaModel") AsistenciaModel asistenciaModel, Model model) throws Exception {
        log.info("Method: addAsistencia() -- Params: " + asistenciaModel.toString());

        asistenciaService.addAsistencia(asistenciaModel);

        return "redirect:/eventos/calendario";
    }

    @GetMapping("/findAsistente")
    public String findAsistente(){

        return null;
    }


}
