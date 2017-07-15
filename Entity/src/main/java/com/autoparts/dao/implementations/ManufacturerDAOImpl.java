package com.autoparts.dao.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.autoparts.dao.HibernateUtil;

import com.autoparts.dao.entity.Country;
import com.autoparts.dao.entity.Manufacturer;
import com.autoparts.dao.interfaces.ManufacturerDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;

/**
 * Created by zms01 on 03.07.2017.
 */
public class ManufacturerDAOImpl implements ManufacturerDAO {

    public void addManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Manufacturer getManufacturerById(Long id) throws SQLException {
        Session session = null;
        Manufacturer manufacturer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            {
                Query query = session.createQuery("FROM Manufacturer WHERE id =:paramId");
                query.setParameter("paramId", id);
                manufacturer = (Manufacturer) query.uniqueResult();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return manufacturer;
    }

    public List<Manufacturer> getAllManufacturers() throws SQLException {
        Session session = null;
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            manufacturers = session.createCriteria(Manufacturer.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return manufacturers;
    }

    public void deleteManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Set<Manufacturer> getCountries(Long countryId) throws SQLException {
        Session session = null;
        Set<Manufacturer> manufacturerList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Country country = (Country) session.load(Country.class, countryId);

            session.beginTransaction();
            manufacturerList = country.getManufacturers();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return manufacturerList;
    }
}

