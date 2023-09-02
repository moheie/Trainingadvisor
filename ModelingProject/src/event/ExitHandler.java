package event;

import java.util.EventListener;

@FunctionalInterface
public interface ExitHandler extends EventListener {
    void handleExit();
}
