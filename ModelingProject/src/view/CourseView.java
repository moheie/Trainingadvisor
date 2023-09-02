package view;

import util.Params;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class CourseView extends MenuView<Void> {
    public CourseView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "View Material"));
        menu.add(new MenuItem(2, "View Videos"));
        menu.add(new MenuItem(3, "Take an Exam"));
    }
}
