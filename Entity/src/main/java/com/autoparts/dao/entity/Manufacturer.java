package com.autoparts.dao.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    private Set<Autopart> autoparts = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "manufacturer")
    public Set<Autopart> getAutoparts() {
        return this.autoparts;
    }

    public void setAutoparts(Set<Autopart> autoparts) {
        this.autoparts = autoparts;
    }

    public void addAutoparts(Autopart autopart) {
        autopart.setManufacturer(this);
        this.autoparts.add(autopart);
    }
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
        return "Manufacturer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country=" + country +
                '}';
    }
}

