package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class ManageCoursesView extends MenuView<Void> {
    public ManageCoursesView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "View all Courses"));
        menu.add(new MenuItem(2, "Add Course"));
        menu.add(new MenuItem(3, "Manage Content"));
        menu.add(new MenuItem(4, "Delete Course"));
        menu.add(new MenuItem(5, "Edit Course"));
    }
}
