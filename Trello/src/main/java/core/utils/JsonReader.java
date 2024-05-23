package core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Map;

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

    /**
     * Gets a Map of entities with the information populated from a JSON file.
     *
     * @param valueTypeRef - TypeReference. Send new TypeReference<Map<String, Account>>() {}
     * @param path  - JSON file path.
     * @param <T> the type of entity obtained by the method.
     * @return Map of entities with the information populated from a JSON file.
     */
    public static <T> Map<String, T> getEntityMapFromJSON(final TypeReference valueTypeRef, final String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (Map<String, T>) mapper.readValue(new File(path), valueTypeRef);
        } catch (IOException e) {
            throw new IllegalArgumentException("The json path is not correct", e);
        }
    }
}
