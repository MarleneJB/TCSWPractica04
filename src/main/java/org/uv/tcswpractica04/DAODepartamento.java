/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica04;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author meli
 */
public class DAODepartamento implements IDAOGeneral<Departamento, Long> {

    @Override
    public boolean create(Departamento pojo) {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(pojo);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Departamento delete(Long id) {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        try {
            Departamento depto = session.get(Departamento.class, id);
            if (depto != null) {
                session.delete(depto);
                t.commit();
                return depto;
            }
            return null;
        } catch (Exception e) {
            t.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Departamento update(Departamento pojo, Long id) {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        try {
            Departamento existente = session.get(Departamento.class, id);
            if (existente != null) {
                existente.setNombre(pojo.getNombre());
                session.update(existente);
                t.commit();
                return existente;
            }
            return null;
        } catch (Exception e) {
            t.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Departamento findById(Long id) {
        Session session = HibernateUtils.getSession();
        try {
            Departamento depto = session.get(Departamento.class, id);
            return depto;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Departamento> findAll() {
        Session session = HibernateUtils.getSession();
        try {
            List<Departamento> lista = session.createQuery("from Departamento", Departamento.class).list();
            return lista;
        } finally {
            session.close();
        }
    }
}


