/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica04;

import java.util.logging.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author melis
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    
    private HibernateUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            Logger.getLogger("Initial Session Factory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
        
    }
    public static Session getSession(){
        return sessionFactory.openSession();
        
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
}
