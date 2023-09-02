package util;

public class ValueBinding<T> {
    private T value;

    public T get() {
        return value;
    }

    public void set(T newValue) {
        value = newValue;
    }

    public ValueBinding(T defaultValue) {
        set(defaultValue);
    }
}
