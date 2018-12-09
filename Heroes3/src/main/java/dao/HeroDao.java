package dao;

import models.Hero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;
import java.util.ArrayList;


public class HeroDao {

    public Hero findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Hero.class, id);
    }

    public void save(Hero hero) {
        //Session session = HibernateSessionFactoryUtil.createSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(hero);
        tx1.commit();
        session.close();
    }

    public void update(Hero hero) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(hero);
        tx1.commit();
        session.close();
    }

    public void delete(Hero hero) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(hero);
        tx1.commit();
        session.close();
    }

    public ArrayList<Hero> findAll() {
        ArrayList<Hero> users = (ArrayList<Hero>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Hero").list();
        return users;

    }
}
