package com.autoparts.dao.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name="Manufacturer")
public  class Manufacturer{
    private Long id;
    private String title;



    public Manufacturer(){
        title=null;
    }
    public Manufacturer(Manufacturer m){
        title = m.getTitle();
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

    public void setId(Long i){
        id = i;
    }

    public void setTitle(String t) {
        title = t;
    }



}

