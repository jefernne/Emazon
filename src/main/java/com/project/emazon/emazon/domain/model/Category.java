package com.project.emazon.emazon.domain.model;

public class Category {
    private Long idCategory;
    private String name;
    private String description;


    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
       this.description = description;
    }
}
