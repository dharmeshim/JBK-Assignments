package com.Operation;

import com.common.hibernateConfig;
import com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.util.List;

public class maxMethod {
    public void maxMethod() {

        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.max("id"));

        List<Employee> maxID = criteria.list();
        System.out.println("MAximum ID " + maxID);

        tr.commit();
        session.close();
    }
}
