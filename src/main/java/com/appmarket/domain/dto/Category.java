package com.appmarket.domain.dto;

public class Category {

    private Integer categoryId;
    private String category;
    private Boolean active;

    public void setCategoryId(Integer categoryId){

        this.categoryId=categoryId;
    }

    public Integer getCategoryId(){

        return this.categoryId;

    }


    public void setCategory(String category){

        this.category= category;

    }

    public String getCategory(){

        return  this.category;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
