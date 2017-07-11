package com.autoparts.dao.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.dao.HibernateUtil;

import com.autoparts.dao.entity.Category;
import com.autoparts.dao.entity.User;
import com.autoparts.dao.interfaces.CategoryDAO;
import org.hibernate.Session;

import javax.swing.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class CategoryDAOImpl implements CategoryDAO {

    public void addCategory(Category category) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public void updateCategory(Category category) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Ошибка I/O",JOptionPane.OK_OPTION);
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public Category getCategoryById(Long id) throws SQLException{
        Session session = null;
        Category category = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            category = (Category) session.load(Category.class, id);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return category;
    }



    public List<Category> getAllCategories() throws SQLException{
        Session session = null;
        List<Category>categories = new ArrayList<Category>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            categories = session.createCriteria(User.class).list();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return categories;
    }
    public void deleteCategory(Category category) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(category);
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

