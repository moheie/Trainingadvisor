package view;

import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class LibraryView extends MenuView<Void> {
    public LibraryView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Interact with Course"));
        menu.add(new MenuItem(2, "View All Courses"));
        menu.add(new MenuItem(3, "Withdraw from Course"));
        menu.add(new MenuItem(4, "Add Ratings"));
        menu.add(new MenuItem(5, "Add Review"));
        menu.add(new MenuItem(6, "Check Progress"));
        menu.add(new MenuItem(7, "Request Certificate"));
    }
}
