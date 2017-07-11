package com.autoparts.dao.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.dao.HibernateUtil;

import com.autoparts.dao.entity.Autopart;
import com.autoparts.dao.interfaces.AutopartDAO;
import org.hibernate.Session;

import javax.swing.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class AutopartDAOImpl implements AutopartDAO {

    public void addAutopart(Autopart autopart) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(autopart);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public void updateAutopart(Autopart autopart) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(autopart);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public Autopart getAutopartById(Long id) throws SQLException{
        Session session = null;
        Autopart autopart = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            autopart = (Autopart) session.load(Autopart.class, id);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return autopart;
    }
    public List<Autopart> getAllAutoparts() throws SQLException{
        Session session = null;
        List<Autopart>autoparts = new ArrayList<Autopart>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            autoparts = session.createCriteria(Autopart.class).list();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return autoparts;
    }
    public void deleteAutopart(Autopart autopart) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(autopart);
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
