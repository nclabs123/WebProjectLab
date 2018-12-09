import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Hero;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import services.HeroService;

public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader requestReader = request.getReader();
        String upreqJSON = requestReader.readLine();
        System.out.println(upreqJSON);
        ObjectMapper upmapper = new ObjectMapper();
        Hero UpdateHuman = upmapper.readValue(upreqJSON, Hero.class);//конвертация в обьект
        HeroService heroService = new HeroService();
        Hero updatehero =  heroService.findHero(UpdateHuman.getId());
        updatehero.setName(UpdateHuman.getName());
        updatehero.setUniverse(UpdateHuman.getUniverse());
        updatehero.setPower(UpdateHuman.getPower());
        updatehero.setDescription(UpdateHuman.getDescription());
        updatehero.setAlive(UpdateHuman.getAlive());
        heroService.updateHero(updatehero);

        ArrayList<Hero> herolist = heroService.findAllHeroes();
        System.out.println(herolist);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArrayList<String> jsonherolist = new ArrayList<String>();
        for(int i=0;i<herolist.size();i++){
            Hero hero = herolist.get(i);
            String test = ow.writeValueAsString(hero);
            jsonherolist.add(test);
        }
        System.out.println(jsonherolist);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonherolist);


    }

}

