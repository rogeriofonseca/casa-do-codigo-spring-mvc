package org.casadocodigo.loja.controllers.models;

public class Product {
    private String title;
    private String description;
    private int pages;

    public String getTittle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
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
        return "Product{" + "tittle=" + title + ", description=" + description + ", pages=" + pages + '}';
    }
}
