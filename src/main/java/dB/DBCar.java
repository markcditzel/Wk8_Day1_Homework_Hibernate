package dB;

import models.Car;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCar {

    private static Session session;
    private static Transaction transaction;

    public static void save(Car car) { // save method not being recognised / used below???
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Get a List of all the Car Class-associated objects
    public static List<Car> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Car> results = null;
        try {
            Criteria cr = session.createCriteria(Car.class);
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    //Get a specific Car class object by searching for its unique id
    public static Car findById(int id) { // search by id
        Car results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Car.class);
            cr.add(Restrictions.eq("id",id)); // filter list by matching supplied id
            results = (Car) cr.uniqueResult(); // casting the returned object into a Car type object;
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }


}
