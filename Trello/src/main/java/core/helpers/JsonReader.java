package core.helpers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public final class JsonReader {

    public static DocumentContext getJsonObjet(final String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Reader fileReader = new InputStreamReader(inputStream);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(fileReader);
            return JsonPath.parse(jsonObject);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("It was not possible to read the Json file.");
        }
    }
}
