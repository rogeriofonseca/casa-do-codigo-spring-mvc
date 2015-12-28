package org.casadocodigo.loja.models;

import java.math.BigDecimal;

public class ShoppingItem {

    private Product product;
    private BookType bookType;
    private Integer productId;

    public ShoppingItem(Product product, BookType bookType) {
        this.product = product;
        this.bookType = bookType;
        this.productId = product.getId();

    }

    BigDecimal getTotal(Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
