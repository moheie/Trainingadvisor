package view;

import util.Params;
import util.ValueBinding;
import view.menu.MenuItem;
import view.menu.MenuView;

public class TraineeView extends MenuView<Void> {
    public TraineeView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    protected void initialize() {
        menu.add(new MenuItem(1, "Manage Profile"));
        menu.add(new MenuItem(2, "View Library"));
        menu.add(new MenuItem(3, "View Profile"));
        menu.add(new MenuItem(4, "Search"));
        menu.add(new MenuItem(5, "Enroll in a Course"));
        menu.add(new MenuItem(6, "Help Desk"));
    }

    @Override
    public void display(Void params) {
        System.out.println("Trainee Menu:");

        super.display(params);
    }
}
