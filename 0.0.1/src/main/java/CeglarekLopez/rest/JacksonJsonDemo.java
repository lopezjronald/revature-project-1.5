package CeglarekLopez.rest;

import CeglarekLopez.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonJsonDemo {

    public static void main(String[] args) {

        try {
            // Create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java Pojo
            // Data/sample-lite.json
            User user = mapper.readValue(new File("src/main/resources/sample-lite.json"), User.class);

            // print first and last name
            System.out.println(user.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
