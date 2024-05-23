package core;

import com.jayway.jsonpath.DocumentContext;
import core.utils.JsonReader;

public final class Environment {

    private static final Environment instance = new Environment();

    private final DocumentContext jsonContext;
    private Environment() {
            jsonContext = JsonReader.getJsonObjet("config/config.json");
    }

    public static Environment getInstance() {
        return instance;
    }

    public String getValue(final String jsonKey) {
        return jsonContext.read(jsonKey);
    }
}
