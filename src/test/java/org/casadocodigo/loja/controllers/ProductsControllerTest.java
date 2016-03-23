
package org.casadocodigo.loja.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.transaction.Transactional;
import org.casadocodigo.loja.conf.AppWebConfiguration;
import org.casadocodigo.loja.conf.DataSourceConfigurationTest;
import org.casadocodigo.loja.conf.JPAConfiguration;
import org.casadocodigo.loja.conf.SecurityConfiguration;
import org.casadocodigo.loja.daos.ProductDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppWebConfiguration.class, JPAConfiguration.class, SecurityConfiguration.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductsControllerTest {

    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    @Transactional
    public void shouldListAllBooksInTheHome() throws Exception {
        this.mockMvc.perform(get("/produtos"))
            .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/products/list.jsp"));
    }
}
