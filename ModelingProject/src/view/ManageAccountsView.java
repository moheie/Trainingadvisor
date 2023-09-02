package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class ManageAccountsView extends MenuView<Void> {
    public ManageAccountsView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Print All Accounts"));
        menu.add(new MenuItem(2, "Add a New Account"));
        menu.add(new MenuItem(3, "Delete Account"));
        menu.add(new MenuItem(4, "Change Role for an Account"));
        menu.add(new MenuItem(5, "Edit my Account"));
    }
}
