package org.casadocodigo.loja.controllers;

import java.util.Map;
import javax.transaction.Transactional;
import org.casadocodigo.loja.models.Product;
import org.casadocodigo.loja.daos.ProductDAO;
import org.casadocodigo.loja.models.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class ProductsController {
    
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping("/produtos/form")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", BookType.values());
        return modelAndView;
    }
    
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products",productDAO.list());
        return modelAndView;
    }
    
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public String save(Product product){
        productDAO.save(product);
        return "products/ok";
    }
}
