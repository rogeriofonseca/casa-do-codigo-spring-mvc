package org.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.casadocodigo.loja.builders.ProductBuilder;
import org.casadocodigo.loja.conf.DataSourceConfigurationTest;
import org.casadocodigo.loja.conf.JPAConfiguration;
import org.casadocodigo.loja.models.BookType;
import org.casadocodigo.loja.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProductDAO.class, JPAConfiguration.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductDAOTest {
    
    @Autowired
    private ProductDAO productDAO;
    
    @Transactional
    @Test
    public void shouldSumAllPricesOfEachBookPerType(){
        
        //salva uma lista de livros impressos
        List<Product> printedBooks = ProductBuilder.newProduct(BookType.PRINTED, BigDecimal.TEN).more(4).buildAll();
        //foreach do Java8, fique a vontade para usar o for normal
        printedBooks.stream().forEach(productDAO::save);
        //salva uma lista de ebooks
        List<Product> ebooks = ProductBuilder.newProduct(BookType.EBOOK, BigDecimal.TEN).more(4).buildAll();
        //foreach do Java8, fique a vontade para usar o for normal
        ebooks.stream().forEach(productDAO::save);
        
        BigDecimal value = productDAO.sumPricesPerType(BookType.PRINTED);
        Assert.assertEquals(new BigDecimal(50).setScale(2), value);
        
    }
}
