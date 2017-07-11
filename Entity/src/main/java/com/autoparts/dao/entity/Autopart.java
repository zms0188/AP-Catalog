package com.autoparts.dao.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name="Autopart")
public  class Autopart{
    private Long id;
    private String title;
    private Double price;


    public Autopart(){
        title=null;
    }
    public Autopart(Autopart a){
        title = a.getTitle();
    }
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    public Long getId(){
        return id;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "price")
    public Double getPrice(){return  price;}

    public void setId(Long i){
        id = i;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setPrice(Double p) {
        price = p;
    }
}

