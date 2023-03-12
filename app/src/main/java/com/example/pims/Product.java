package com.example.pims;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Product implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pro_name")
    @Expose
    private String proName;
    @SerializedName("cat_id")
    @Expose
    private String catId;

    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("pro_image")
    @Expose
    private String proImage;
    @SerializedName("pro_discription")
    @Expose
    private String proDiscription;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProDiscription() {
        return proDiscription;
    }

    public void setProDiscription(String proDiscription) {
        this.proDiscription = proDiscription;
    }
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", catId='" + catId + '\'' +
                ", catName='" + catName + '\'' +
                ", proImage='" + proImage + '\'' +
                ", proDiscription='" + proDiscription + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}