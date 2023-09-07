package com.Operation;

import com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.common.hibernateConfig;

public class SaveData {
    public void saveData() {

        SessionFactory sf = hibernateConfig.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Employee employee = new Employee();
        employee.setId(7);
        employee.setName("aravind");
        employee.setEmail("aravind@gmail");
        employee.setRole("manage");
        employee.setSalary(123400);

        session.save(employee);

        tr.commit();
        session.close();
        System.out.println("data stored");
    }
}
