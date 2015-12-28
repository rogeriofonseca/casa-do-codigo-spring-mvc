package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.casadocodigo.loja.daos.ProductDAO;
import org.casadocodigo.loja.infra.FileSaver;
import org.casadocodigo.loja.models.ShoppingCart;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProductDAO.class, FileSaver.class, ShoppingCart.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter{
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setBasename("/WEB-INF/messages");
        bundle.setDefaultEncoding("UTF-8");
        bundle.setCacheSeconds(1);
        return bundle;
    }
    
    @Bean
    public FormattingConversionService mvcConversionService(){
        DefaultFormattingConversionService conversionService = 
            new DefaultFormattingConversionService(true);
        
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);
        return conversionService;
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
