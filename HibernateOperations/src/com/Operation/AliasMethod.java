package com.Operation;

import com.common.hibernateConfig;
import com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.util.List;

public class AliasMethod {
    public void aliasMethod() {
        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.alias(Projections.distinct(Projections.property("role")), "distinctRole"));

        List<Employee> distinctRole = criteria.list();
        System.out.println("distinct roles " + distinctRole);

        tr.commit();
        session.close();
    }
}
