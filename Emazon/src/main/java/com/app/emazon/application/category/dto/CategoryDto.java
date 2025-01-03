package com.app.emazon.application.category.dto;

public class CategoryDto {
    private Long idCateogry;
    private String nombreCateogry;
    private String descripcionCateogry;


    public CategoryDto(Long idCateogry, String nombreCateogry, String descripcionCateogry) {
        this.idCateogry = idCateogry;
        this.nombreCateogry = nombreCateogry;
        this.descripcionCateogry = descripcionCateogry;
    }

    public CategoryDto() {
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
