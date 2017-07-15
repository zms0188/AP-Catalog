package com.autoparts.dao.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name="Country")
public  class Country{
    private Long id;
    private String title;


    public Country(){
        title=null;
    }
    public Country(Country c){
        title = c.getTitle();
    }

    private Set<Manufacturer> manufacturers = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "country")
    public Set<Manufacturer> getManufacturers() {
        return this.manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public void addManufacturers(Manufacturer manufacturer) {
        manufacturer.setCountry(this);
        this.manufacturers.add(manufacturer);
    }

    private Set<Automobile> automobiles = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "country")
    public Set<Automobile> getAutomobiles() {
        return this.automobiles;
    }

    public void setAutomobiles(Set<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    public void addAutomobiles(Automobile automobile) {
        automobile.setCountry(this);
        this.automobiles.add(automobile);
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

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturers=" + manufacturers +
                '}';
    }
}

