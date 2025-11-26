/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tcswpractica04;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author meli
 */
public class TCSWPractica04 {

    public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setNombre("Sistemas");
        dep.setClave(2L);
        
        Empleados emp = new Empleados();
        emp.setNombre("Melissa");
        emp.setDireccion("Fortin");
        emp.setTelefono("4444");
        emp.setDepartamento(dep);
        emp.setClave(7L);
        
        Session session = HibernateUtils.getSession();
        Transaction t=session.beginTransaction();
        Departamento d1=session.get(Departamento.class, 1L);
        emp.setDepartamento(d1);
        session.update(emp);
        
        t.commit();
        Logger.getLogger(TCSWPractica04.class.getName()).log(Level.INFO, "Se conecto");
       
        
        
        
//        SwingUtilities.invokeLater(() -> {
//            try {
//           
//                HibernateUtils.getSessionFactory();
//                
//                Vista vista = new Vista();
//                vista.setVisible(true);
//                
//            } catch (Exception e) {
//                Logger.getLogger(TCSWPractica05.class.getName()).log(Level.INFO, "Error al iniciar la aplicacion", e);
//                
//            }
//        });
//    }
    }
    }
    
