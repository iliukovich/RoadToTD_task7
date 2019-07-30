package framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {

    public static <T> T mapToObject(String filepath, Class<T> targetClass) {
        JSONObject jsonObject = readFromFile(filepath);
        return new Gson().fromJson(jsonObject.toJSONString(), targetClass);
    }

    private static JSONObject readFromFile(String filepath) {
        JSONObject data = null;
        try {
            data = (JSONObject) new JSONParser().parse(new FileReader(filepath));
        } catch (IOException | ParseException e) {
            System.err.println(e);
        }
        return data;
    }

    public static void writeToFile(String filepath, Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filepath)) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
