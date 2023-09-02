package event;

import java.util.EventListener;

@FunctionalInterface
public interface SubmitHandler<T> extends EventListener {
    void handleSubmit(T data);
}
