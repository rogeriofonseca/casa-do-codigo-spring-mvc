
package org.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.casadocodigo.loja.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager manager;
    
    
    public void save(Product product) {
        manager.persist(product);
    }

}
