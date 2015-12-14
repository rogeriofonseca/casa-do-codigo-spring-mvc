package org.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppWebConfiguration.class, JPAConfiguration.class, AmazonConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
    @Override
    protected void customizeRegistration(Dynamic registration){
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }
}
