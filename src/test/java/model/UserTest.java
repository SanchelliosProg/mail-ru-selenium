package model;

import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by avvasi78 on 02.12.2016.
 */
public class UserTest {
    @Test
    public void testGSONParsing(){
        JSONParser parser = new JSONParser();
        try {
            String json = (parser.parse(new FileReader("./resources/test_data/correct_user.json"))).toString();
            Gson gson = new Gson();
            User user = gson.fromJson(json, User.class);
            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}