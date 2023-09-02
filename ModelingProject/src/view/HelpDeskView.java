package view;

import util.Params;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class HelpDeskView extends MenuView<Void> {
    public HelpDeskView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Write message"));
        menu.add(new MenuItem(2, "View messages"));
    }

    @Override
    public void display(Void params) {
        System.out.println("Welcome to the help desk");

        super.display(params);
    }
}
