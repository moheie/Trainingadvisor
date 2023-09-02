package event;

import view.menu.MenuItem;
import java.util.EventListener;

@FunctionalInterface
public interface SelectionHandler extends EventListener {
    void handleMenuSelection(MenuItem item);
}
