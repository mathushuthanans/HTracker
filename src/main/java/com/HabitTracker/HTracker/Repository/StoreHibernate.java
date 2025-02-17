package com.HabitTracker.HTracker.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.HabitTracker.HTracker.model.Habit;

@Repository
public class StoreHibernate {
    private static SessionFactory sessionFactory;

    static{
        try{
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(com.HabitTracker.HTracker.model.Habit.class);
            cfg.configure("hibernate.cfg.xml");

            sessionFactory = cfg.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory creation failed!");
        }
    }

    public void save(Habit habit){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.persist(habit);
        transaction.commit();   
        session.close();  
        
    }
    public void updated(Habit habit) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();  

        session.merge(habit);  
        tx.commit();  
        session.close();
    }
    

    public List<Habit> retrieve(){
        List <Habit> habitsList;
        try(Session session = sessionFactory.openSession()){
            Query <Habit> query = session.createQuery("FROM Habit", Habit.class);
            habitsList = query.list();
            session.close();
        }

        return habitsList;
    }
    
}
