package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ITERM")
public class Iterm {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private  Integer id;
    @Column(name = "BRAND", length = 255)
    private String brand;
    @Column(name = "CATEGORY", length = 255)
    private String category;
    @Column(name = "NUM", length = 11)
    private Integer num;
    @Column(name = "MODEL", length = 255)
    private String model;
    @Column(name = "warehouse", length = 255)
    private String warehouse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Iterm{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", num=" + num +
                ", model='" + model + '\'' +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }
}
