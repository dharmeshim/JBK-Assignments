package com.Operation;

import com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.common.hibernateConfig;
import org.hibernate.Transaction;

public class LoadData {

    public void loadMethod() {
        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee);

        tr.commit();
        session.close();

    }
}
