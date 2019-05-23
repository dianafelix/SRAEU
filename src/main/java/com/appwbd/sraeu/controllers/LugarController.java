package com.appwbd.sraeu.controllers;


import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.LugarModel;
import com.appwbd.sraeu.services.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/lugares")
public class LugarController {

    @Autowired
    @Qualifier("lugarServiceImpl")
    private LugarService lugarService;

    private static final Log log = LogFactory.getLog(LugarController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/lugares/showLugares";
    }

    @GetMapping("/lugarForm")
    public String redirectLugarForm(Model model, @RequestParam(name = "id", required = false) int id) {
        LugarModel lugarModel = new LugarModel();
        boolean b = true;
        if(id != 0) {
            lugarModel = lugarService.findLugarByIdModel(id);
            b = false;
        }
        model.addAttribute("lugarModel",lugarModel);
        model.addAttribute("b",b);
        return ViewConstant.LUGAR_FORM;
    }

    @PostMapping("/addlugar")
    public String addLugar(@ModelAttribute(name = "lugarModel") LugarModel lugarModel, Model model){
        log.info("Method: addLugar() -- Params: " + lugarModel.toString());
        if (lugarService.addLugar(lugarModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/lugares/showLugares";
    }

    @GetMapping("/showLugares")
    public ModelAndView showLugares() {
        ModelAndView mav = new ModelAndView(ViewConstant.LUGARES);
        mav.addObject("lugares",lugarService.listAllLugares());
        return mav;
    }

    @GetMapping("/removeLugar")
    public ModelAndView removeLugar(@RequestParam(name = "id",required = true)int id) {
        lugarService.removeLugar(id);
        return showLugares();
    }
}
