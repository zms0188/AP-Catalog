package com.autoparts.dao.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name="Automobile")
public  class Automobile{
    private Long id;
    private String title;
    private String model;


    public Automobile(){
        title=null;
    }
    public Automobile(Automobile a){
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

    @Column(name = "model")
    public String getModel(){return  model;}

    public void setId(Long i){
        id = i;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setModel(String m) {
        model = m;
    }
}

