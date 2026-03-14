package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT OPERATION
        Vehicle v = new Vehicle();
        v.setName("Car");
        v.setDescription("Electric Vehicle");
        v.setDate(new Date());
        v.setStatus("Available");
        v.setModel("Tesla Model 3");
        v.setManufacturer("Tesla");

        session.save(v);

        System.out.println("Vehicle Inserted Successfully");

        tx.commit();

        // UPDATE OPERATION
        Transaction tx2 = session.beginTransaction();

        Vehicle vehicle = session.get(Vehicle.class, 1);

        if(vehicle != null)
        {
            vehicle.setName("Updated Car");
            vehicle.setStatus("Sold");

            session.update(vehicle);

            System.out.println("Vehicle Updated Successfully");
        }

        tx2.commit();

        session.close();
        sf.close();
    }
}
