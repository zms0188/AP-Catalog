package com.autoparts.dao.entity;


import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name = "Automobile", catalog = "my_db")
public class Automobile {
    private Long id;
    private String title;
    private String model;


    public Automobile() {
        title = null;
    }

    public Automobile(Automobile am) {
        title = am.getTitle();
    }

    private Set<Autopart> autoparts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "automobile")
    public Set<Autopart> getAutoparts() {
        return this.autoparts;
    }

    public void setAutoparts(Set<Autopart> autoparts) {
        this.autoparts = autoparts;
    }

    public void addAutoparts(Autopart autopart) {
        autopart.setAutomobile(this);
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
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setId(Long i) {
        id = i;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setModel(String m) {
        model = m;
    }
}

