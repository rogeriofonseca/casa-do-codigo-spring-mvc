package org.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index(){
//        System.out.println("Carregando produtos...");
        return new ModelAndView("redirect:/produtos");
    }
}
