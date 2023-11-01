package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id",length = 5)
    //Khi là String thì không đuược có độ dài vượt quá 1000/6 ký tự
    private String productId;
    @Column(name = "product_name", nullable = false, unique = true, length = 100)
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "product_status")
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Categories catalog;

    public Product() {
    }

    public Product(String productId, String productName, float price, boolean status, Categories catalog) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categories getCatalog() {
        return catalog;
    }

    public void setCatalog(Categories catalog) {
        this.catalog = catalog;
    }
}
