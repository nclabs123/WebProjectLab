package test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import models.Hero;

public class Test {
    /*public static void main(String[] args) throws IOException {

        Hero human = new Hero();
        human.this.name = "Cap";
        human.universe = "Marvel";

        // convert to json
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(human);
        System.out.println("json " + jsonString); // print "json {"message":"Hi","place":{"name":"World"}}"

        // convert from json
        Hero newHuman = mapper.readValue(jsonString, Hero.class);
        System.out.println(newHuman.getName() +newHuman.getUniverse() );
    }
*/
}
