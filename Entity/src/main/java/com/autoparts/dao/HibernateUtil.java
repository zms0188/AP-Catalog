package com.autoparts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by zms01 on 03.07.2017.
 */
public class HibernateUtil {
    private static SessionFactory  sessionFactory=null;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();}
        }

  public static SessionFactory getSessionFactory() {
      return sessionFactory;
  }
}

