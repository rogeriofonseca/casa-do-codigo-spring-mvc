
package org.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import org.casadocodigo.loja.models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private ShoppingCart shoppingCart;
    
    @RequestMapping(value="checkout",method=RequestMethod.POST)
    public String checkout(){
        BigDecimal total = shoppingCart.getTotal();
        
        // código de integração
        return "redirect:/success";
    }
}
