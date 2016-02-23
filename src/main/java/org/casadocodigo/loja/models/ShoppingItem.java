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

    public BigDecimal getTotal(Integer quantity) {
        return getPrice().multiply(new BigDecimal(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public BookType getBookType() {
        return bookType;
    }

    public BigDecimal getPrice() {
        /**
         * Navegue também até a classe Product, para descobrir como é a
         * implementação do método priceFor *
         */
        return product.priceFor(bookType);
    }
}
