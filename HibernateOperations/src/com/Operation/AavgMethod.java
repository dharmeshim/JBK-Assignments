package com.Operation;

import com.common.hibernateConfig;
import com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.util.List;

public class AavgMethod {
    public void avgMethod() {
        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.avg("salary"));

        List<Employee> avgSalary = criteria.list();
        System.out.println("average number of salary " + avgSalary);

        tr.commit();
        session.close();
    }
}
