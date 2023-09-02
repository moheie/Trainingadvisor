package event;

import util.Params;

import java.util.EventListener;

@FunctionalInterface
public interface NavigationHandler extends EventListener {
    void handleNavigate(String path, Params params);
}
