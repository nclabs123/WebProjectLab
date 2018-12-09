package services;

import dao.HeroDao;
import models.Hero;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.ArrayList;

public class HeroService {

    private HeroDao heroesDao = new HeroDao();

    public HeroService() {
    }

    public Hero findHero(int id) {
        //return (Hero) HibernateSessionFactoryUtil.getSessionFactory().openStatelessSession().get(Hero.class, id);
        return heroesDao.findById(id);
    }

    public void saveHero(Hero hero) {
        heroesDao.save(hero);
    }

    public void deleteHero(Hero hero) {
        heroesDao.delete(hero);
    }

    public void updateHero(Hero hero) {
        heroesDao.update(hero);
    }

    public ArrayList<Hero> findAllHeroes() {
        return  heroesDao.findAll();
    }

}
