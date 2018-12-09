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


public class AddServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader requestReader = request.getReader();
        String reqJSON = requestReader.readLine();
        ObjectMapper mapper = new ObjectMapper();
        Hero newHuman = mapper.readValue(reqJSON, Hero.class);//конвертация в обьект
         System.out.println(newHuman.name);
        HeroService heroService = new HeroService();
        heroService.saveHero(newHuman);



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
