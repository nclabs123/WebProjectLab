import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Hero;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {
    private ArrayList<Hero> herolist = new ArrayList<Hero>();
    //private ArrayList<String> jsonherolist = new ArrayList<String>();




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
        herolist.add(newHuman);
        System.out.println(herolist);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArrayList<String> jsonherolist = new ArrayList<String>();
       for(int i=0;i<herolist.size();i++){
           Hero hero = herolist.get(i);
           hero.setId(i);

           String test = ow.writeValueAsString(hero);
           jsonherolist.add(test);
       }
                System.out.println(jsonherolist);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.print(jsonherolist);


        }




    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader requestReader = request.getReader();
        String delreqJSON = requestReader.readLine();
        System.out.println(delreqJSON);
        String[] arr = delreqJSON.split("_");

        int heronumber = Integer.parseInt(arr[1]);
        herolist.remove(heronumber);
        System.out.println(herolist);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArrayList<String> jsonherolist = new ArrayList<String>();
        for(int i=0;i<herolist.size();i++){
            String test = ow.writeValueAsString(herolist.get(i));
            jsonherolist.add(test);
        }
        System.out.println(jsonherolist);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonherolist);


    }





    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader requestReader = request.getReader();
        String upreqJSON = requestReader.readLine();
        System.out.println(upreqJSON);
        ObjectMapper upmapper = new ObjectMapper();
        Hero UpdateHuman = upmapper.readValue(upreqJSON, Hero.class);//конвертация в обьект
        herolist.set(UpdateHuman.id,UpdateHuman);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ArrayList<String> jsonherolist = new ArrayList<String>();
        for(int i=0;i<herolist.size();i++){
            String test = ow.writeValueAsString(herolist.get(i));
            jsonherolist.add(test);
        }
        System.out.println(jsonherolist);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonherolist);


    }



    }











