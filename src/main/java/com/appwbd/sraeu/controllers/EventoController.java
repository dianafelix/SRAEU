package com.appwbd.sraeu.controllers;


import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.services.AsistenteService;
import com.appwbd.sraeu.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    @Qualifier("eventoServiceImpl")
    private EventoService eventoService;

    @Autowired
    @Qualifier("asistenteServiceImpl")
    private AsistenteService asistenteService;

    /*@Autowired
    @Qualifier("lugarServiceImpl")
    private LugarService lugarService;*/

    //private List<Lugar> lugares;

    private static final Log log = LogFactory.getLog(EventoController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/eventos/showEventos";
    }

    @GetMapping("/eventoForm")
    public String redirectEventoForm(Model model, @RequestParam(name = "id", required = false) int id) {
        EventoModel eventoModel = new EventoModel();
        //List<AsistenteModel> asistenteModels = asistenteService.listAllAsistentes();
       // List<LugarModel> lugarModels = lugarService.listAllLugares();
        boolean b = true;
        if(id != 0) {
            eventoModel = eventoService.findEventoByIdModel(id);
            b = false;
        }
        model.addAttribute("eventoModel",eventoModel);
        //model.addAttribute("asistenteModels", asistenteModels);
        //model.addAttribute("lugarModels", lugarModels);
        model.addAttribute("b",b);
        return ViewConstant.EVENTO_FORM;
    }

    @PostMapping("/addevento")
    public String addEvento(@ModelAttribute(name = "eventoModel") EventoModel eventoModel, Model model)throws Exception {
        log.info("Method: addEvento() -- Params: " + eventoModel.toString());
        if (eventoService.addEvento(eventoModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/eventos/showEventos";
    }

    @GetMapping("/showEventos")
    public ModelAndView showEventos() {
        ModelAndView mav = new ModelAndView(ViewConstant.EVENTOS);
        mav.addObject("eventos",eventoService.listAllEventos());
        return mav;
    }

    @GetMapping("/removeEvento")
    public ModelAndView removeEvento(@RequestParam(name = "id",required = true)int id) {
        eventoService.removeEvento(id);
        return showEventos();
    }

    @GetMapping("/calendario")
    public String calendario(Model model) {
        model.addAttribute("lista", eventoService.listAllEventos());
        return ViewConstant.CALENDARIO;
    }
}
