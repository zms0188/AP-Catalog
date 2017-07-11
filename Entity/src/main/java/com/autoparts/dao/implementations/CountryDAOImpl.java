package com.autoparts.dao.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.dao.HibernateUtil;

import com.autoparts.dao.entity.Country;
import com.autoparts.dao.interfaces.CountryDAO;
import org.hibernate.Session;

import javax.swing.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class CountryDAOImpl implements CountryDAO {

    public void addCountry(Country country) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public void updateCountry(Country country) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(country);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public Country getCountryById(Long id) throws SQLException{
        Session session = null;
        Country country = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            country = (Country) session.load(Country.class, id);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return country;
    }
    public List<Country> getAllCountries() throws SQLException{
        Session session = null;
        List<Country>countries = new ArrayList<Country>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            countries = session.createCriteria(Country.class).list();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return countries;
    }
    public void deleteCountry(Country country) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(country);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
