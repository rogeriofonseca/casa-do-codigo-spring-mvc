package org.casadocodigo.loja.controllers.models;

public class Product {
    private String tittle;
    private String description;
    private int pages;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Product{" + "tittle=" + tittle + ", description=" + description + ", pages=" + pages + '}';
    }
}
