package com.autoparts.dao.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zms01 on 04.07.2017.
 */
@Entity
@Table(name="User")
public  class User{
    private Long id;
    private String login;
    private String password;

    public User(){
        login=null;
    }
    public User(User u){
        login = u.getLogin();
    }
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    public Long getId(){
        return id;
    }
    @Column(name = "login")
    public String getLogin() {
        return login;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setId(Long i){
        id = i;
    }

    public void setLogin(String s) {
        login = s;
    }

    public void setPassword(String p) {
        password = p;
    }
}

