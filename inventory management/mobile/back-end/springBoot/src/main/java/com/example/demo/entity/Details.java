package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DETAILS")
public class Details {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private  Integer id;
    @Column(name = "OPERATOR", length = 255)
    private String operator;
    @Column(name = "OPERATION", length = 255)
    private String operation;
    @Column(name = "TIME", length = 255)
    private Timestamp time;
    @Column(name = "NUM", length = 11)
    private Integer num;
    @Column(name = "MODEL", length = 255)
    private String model;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Column(name = "warehouse", length = 255)
    private String warehouse;
    @Column(name = "BRAND", length = 255)
    private String brand;
    @Column(name = "CATEGORY", length = 255)
    private String category;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }



    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
        return "Details{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", operation='" + operation + '\'' +
                ", time=" + time +
                ", num=" + num +
                ", model='" + model + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
