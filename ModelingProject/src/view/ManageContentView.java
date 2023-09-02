package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class ManageContentView extends MenuView<Void> {
    public ManageContentView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Add Material"));
        menu.add(new MenuItem(2, "Add Video"));
        menu.add(new MenuItem(3, "Add Exam"));
        menu.add(new MenuItem(4, "View Content"));
    }
}
