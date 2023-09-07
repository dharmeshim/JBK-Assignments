package com.Operation;

import com.common.hibernateConfig;
import com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class neMethod {
    public void neMethod() {
        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.ne("name", "dpr"));

        List<Employee> list = criteria.list();
        for (Employee employee : list) {
            System.out.println(employee);
        }

        tr.commit();
        session.close();
    }
}
