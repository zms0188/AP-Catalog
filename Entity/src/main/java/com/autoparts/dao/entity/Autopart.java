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

    private Manufacturer manufacturer;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    private Automobile automobile;
    @ManyToOne
    @JoinColumn(name = "automobile_id", referencedColumnName = "id")
    public Automobile getAutomobile() {
        return this.automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
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

