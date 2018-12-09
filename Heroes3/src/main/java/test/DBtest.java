package test;

import models.Hero;
import services.HeroService;

import java.sql.SQLException;

public class DBtest {

    public static void main(String[] args) throws SQLException {

        HeroService heroService = new HeroService();
        Hero hero = new Hero("Cap","Marvel",100,"Very old hero",true);
        heroService.saveHero(hero);
        heroService.findAllHeroes();
        System.out.println(heroService.findAllHeroes().get(1).getId());
        //Hero findedHero = heroService.findHero(1);
        //System.out.println(findedHero);



    }

}
