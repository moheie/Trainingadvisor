package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Params extends HashMap<String, Object> {
    public Params add(Params params) {
        for (Map.Entry<String, Object> set: params.entrySet()) {
            this.put(set.getKey(), set.getValue());
        }

        return this;
    }

    public Optional<Boolean> getBoolean(String key) {
        Object value = get(key);

        if (value instanceof Boolean) {
            return Optional.of((boolean) value);
        }

        return Optional.empty();
    }

    public Optional<Integer> getInt(String key) {
        Object value = get(key);

        if (value instanceof Integer) {
            return Optional.of((int) value);
        }

        return Optional.empty();
    }
}
