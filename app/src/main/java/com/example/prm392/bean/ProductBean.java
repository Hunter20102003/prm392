package com.example.prm392.bean;

import com.example.prm392.entity.ProductImage;
import com.example.prm392.enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProductBean {
    private Integer productId;
    private String name;
    private String title;
    private String description;
    private Double oldPrice;
    private Double newPrice;
    private Integer categoryId;
    private Integer stockQuantity ;
    private String weight;
    private String dimensions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ProductStatus status ;
    private CategoryBean category;
    private List<ProductImageBean> productImageList;


    public ProductBean() {
        productImageList = new java.util.ArrayList<>();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public List<ProductImageBean> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImageBean> productImageList) {
        this.productImageList = productImageList;
    }
}
