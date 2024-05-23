package trello.config;

import com.fasterxml.jackson.core.type.TypeReference;
import core.utils.JsonReader;
import trello.ui.entities.User;

import java.util.Map;

public final class UserConfig {

    public static User getUserByAlias(final String userAlias) {
        Map<String, User> users =
                JsonReader.getEntityMapFromJSON(new TypeReference<Map<String, User>>() {}, "config/users.json");
        return users.get(userAlias);
    }
}
