package com.kfluous.webload.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport{
    @Autowired
    private SessionFactory mSessionFactory;

    @Autowired
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public Session getSession() {
        return mSessionFactory.getCurrentSession();
    }
}


