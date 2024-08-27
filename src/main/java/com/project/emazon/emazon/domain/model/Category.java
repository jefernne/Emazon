package com.project.emazon.emazon.domain.model;

public class Category {
    private Long Id_Category;
    private String name;
    private String description;

    public Long getId_Category() {
        return Id_Category;
    }

    public void setId_Category(Long id_Category) {
        Id_Category = id_Category;
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
