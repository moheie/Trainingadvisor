package view;

import util.Params;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class MainView extends MenuView<Void> {
    public MainView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Use Help Desk"));
        menu.add(new MenuItem(2, "Sign In"));
        menu.add(new MenuItem(3, "Sign Up"));
    }

    @Override
    public void display(Void params) {
        System.out.println("Select an option:");

        super.display(params);
    }
}
