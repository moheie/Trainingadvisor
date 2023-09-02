package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class AdminView extends MenuView<Void> {
    public AdminView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Manage Accounts"));
        menu.add(new MenuItem(2, "Manage Courses"));
        menu.add(new MenuItem(3, "View Reports and Analytics"));
        menu.add(new MenuItem(4, "Help Desk"));
    }
}
