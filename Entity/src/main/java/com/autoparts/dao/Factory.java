package com.autoparts.dao;

import com.autoparts.dao.entity.Manufacturer;
import com.autoparts.dao.implementations.*;
import com.autoparts.dao.interfaces.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class Factory {
    private static UserDAO userDAO = null;
    private static Factory instance = null;
    private static CategoryDAO categoryDAO = null;
    private static AutomobileDAO automobileDAO = null;
    private static CountryDAO countryDAO = null;
    private static ManufacturerDAO manufacturerDAO = null;
    private static AutopartDAO autopartDAO = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }
    public UserDAO getUserDAO(){
        if(userDAO == null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
    public CategoryDAO getCategoryDAO(){
        if(categoryDAO == null){
            categoryDAO = new CategoryDAOImpl() {
            };
        }
        return categoryDAO;
    }
    public AutomobileDAO getAutomobileDAO(){
        if (automobileDAO == null){
            automobileDAO=new AutomobileDAOImpl() {
            };
        }
        return  automobileDAO;
    }
    public CountryDAO getCountryDAO(){
        if (countryDAO == null){
            countryDAO=new CountryDAOImpl() {
            };
        }
        return  countryDAO;
    }
    public ManufacturerDAO getManufacturerDAO(){
        if (manufacturerDAO == null){
            manufacturerDAO=new ManufacturerDAOImpl() {
            };
        }
        return  manufacturerDAO;
    }
    public AutopartDAO getAutopartDAO(){
        if (autopartDAO == null){
            autopartDAO=new AutopartDAOImpl() {
            };
        }
        return  autopartDAO;
    }
}
