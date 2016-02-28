package org.casadocodigo.loja.controllers;

import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.casadocodigo.loja.models.Product;
import org.casadocodigo.loja.daos.ProductDAO;
import org.casadocodigo.loja.infra.FileSaver;
import org.casadocodigo.loja.models.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
    
    //Por enquanto nao precisamos mais desse metodo.
    //Comente ou apague.
//    @InitBinder
//    protected void initBinder(WebDataBinder binder){
//        binder.setValidator(new ProductValidator());
//    }
    
    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private FileSaver fileSaver;
    
    @RequestMapping("/form")
    public ModelAndView form(Product product){
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", BookType.values());
        return modelAndView;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @Cacheable(value="lastProducts")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products",productDAO.list());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value="books", allEntries = true)
    public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(!summary.isEmpty()){
            String webPath = fileSaver.write("uploaded-images",summary);
            product.setSummaryPath(webPath);
        }
        productDAO.save(product);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
        return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(value="/{id}")
    public ModelAndView show(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("products/show");
        Product product = productDAO.find(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
