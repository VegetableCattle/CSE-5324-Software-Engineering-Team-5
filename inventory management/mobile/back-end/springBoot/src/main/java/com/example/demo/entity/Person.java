package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private  Integer id;
    @Column(name = "NAME", length = 255)
    private String name;
    @Column(name = "AGE", length = 11)
    private Integer age;

    //必须要有构造函数
    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
