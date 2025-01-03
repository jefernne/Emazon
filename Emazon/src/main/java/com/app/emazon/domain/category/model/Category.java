package com.app.emazon.domain.category.model;

public class Category {
    private Long idCateogry;
    private String nombreCateogry;
    private String descripcionCateogry;


    public Category(Long idCateogry, String nombreCateogry, String descripcionCateogry) {
        this.idCateogry = idCateogry;
        this.nombreCateogry = nombreCateogry;
        this.descripcionCateogry = descripcionCateogry;
    }

    public Category() {
    }

    public Long getIdCateogry() {
        return idCateogry;
    }

    public void setIdCateogry(Long idCateogry) {
        this.idCateogry = idCateogry;
    }

    public String getNombreCateogry() {
        return nombreCateogry;
    }

    public void setNombreCateogry(String nombreCateogry) {
        this.nombreCateogry = nombreCateogry;
    }

    public String getDescripcionCateogry() {
        return descripcionCateogry;
    }

    public void setDescripcionCateogry(String descripcionCateogry) {
        this.descripcionCateogry = descripcionCateogry;
    }
}
