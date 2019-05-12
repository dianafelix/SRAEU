package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.services.AsistenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/asistentes")
public class AsistenteController {

    @Autowired
    @Qualifier("asistenteServiceImpl")
    private AsistenteService asistenteService;

    private static final Log log = LogFactory.getLog(UsuarioController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/asistentes/showAsistentes";
    }

    @GetMapping("/asistenteForm")
    public String redirectAsistenteForm(Model model, @RequestParam(name = "id", required = false) int id) {
        AsistenteModel asistenteModel = new AsistenteModel();
        boolean b = true;
        if(id != 0) {
            asistenteModel = asistenteService.findAsistenteByIdModel(id);
            b = false;
        }
        model.addAttribute("asistenteModel",asistenteModel);
        model.addAttribute("b",b);
        return ViewConstant.ASISTENTE_FORM;
    }

    @PostMapping("/addasistente")
    public String addAsistente(@ModelAttribute(name = "asistenteModel") AsistenteModel asistenteModel, Model model) {
        log.info("Method: addAsistente() -- Params: " + asistenteModel.toString());
        if (asistenteService.addAsistente(asistenteModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/asistentes/showAsistentes";
    }

    @GetMapping("/showAsistentes")
    public ModelAndView showAsistentes() {
        ModelAndView mav = new ModelAndView(ViewConstant.ASISTENTES);
        mav.addObject("asistentes",asistenteService.listAllAsistentes());
        return mav;
    }

    @GetMapping("/removeAsistente")
    public ModelAndView removeAsistente(@RequestParam(name = "id",required = true)int id) {
        asistenteService.removeAsistente(id);
        return showAsistentes();
    }
}
