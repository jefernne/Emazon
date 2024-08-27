package com.project.emazon.emazon.application.dtos;

public class CategoryDTO{
    private Long Id_category;
    private String name;
    private String description;


    public Long getId_category() {
        return Id_category;
    }

    public void setId_category(Long id_category) {
        Id_category = id_category;
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
