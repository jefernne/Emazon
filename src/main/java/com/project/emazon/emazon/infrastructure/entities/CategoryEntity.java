package com.project.emazon.emazon.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Category")
    private Long Id_Category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
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
