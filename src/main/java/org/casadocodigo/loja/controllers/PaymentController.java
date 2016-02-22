package org.casadocodigo.loja.controllers;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import java.math.BigDecimal;
import java.util.concurrent.Callable;
import org.casadocodigo.loja.models.PaymentData;
import org.casadocodigo.loja.models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/payment")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class PaymentController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String checkout() {
        BigDecimal total = shoppingCart.getTotal();

        // código de integração
//      String uriToPay = "http://payment.herokuapp.com/payment";
        String uriToPay = "http://localhost:9000/payment";
        
        try {
            String response = restTemplate.postForObject(uriToPay, new PaymentData(total), String.class);
            return "redirect:/payment/successs";
        } catch (HttpClientErrorException exception) {
            return "redirect:/payment/error";
        }
    }
}
