package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class ManageAccountView extends MenuView<Void> {
    public ManageAccountView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Update Name"));
        menu.add(new MenuItem(2, "Update Password"));
        menu.add(new MenuItem(3, "Update Email"));
        menu.add(new MenuItem(4, "Update Phone"));
        menu.add(new MenuItem(5, "Update Photo"));
        menu.add(new MenuItem(6, "Update Address"));
    }
}
