package org.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {
    
    @RequestMapping("/produtos/form")
    public String form(){
        return "products/form";
    }
    
    @RequestMapping()
    public String save(){
        System.out.println("Cadastrando o produto: ");
        return "products/ok";
    }
}
