package com.autoparts.dao.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.dao.HibernateUtil;

import com.autoparts.dao.entity.Automobile;
import com.autoparts.dao.entity.User;
import com.autoparts.dao.interfaces.AutomobileDAO;
import org.hibernate.Session;

import javax.swing.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class AutomobileDAOImpl implements AutomobileDAO {

    public void addAutomobile(Automobile automobile) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(automobile);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public void updateAutomobile(Automobile automobile) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(automobile);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public Automobile getAutomobileById(Long id) throws SQLException{
        Session session = null;
        Automobile automobile = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
             automobile = (Automobile) session.load(Automobile.class, id);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return automobile;
    }
    public List<Automobile> getAllAutomobiles() throws SQLException{
        Session session = null;
        List<Automobile>automobiles = new ArrayList<Automobile>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            automobiles = session.createCriteria(Automobile.class).list();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return automobiles;
    }
    public void deleteAutomobile(Automobile automobile) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(automobile);
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
