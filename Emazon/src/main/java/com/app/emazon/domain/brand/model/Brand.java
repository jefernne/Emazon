package com.app.emazon.domain.brand.model;

public class Brand {
    private Long idBrand;
    private String brandName;
    private String brandDescription;

    public Brand(Long idBrand, String brandName, String brandDescription) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
