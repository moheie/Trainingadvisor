package view.menu;

import event.ExitHandler;
import event.SelectionHandler;
import util.Params;
import util.ValueBinding;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MenuView<T> extends View<T> {
    private SelectionHandler selectionHandler;
    protected Menu menu = new Menu();

    public MenuView(String exitLabel, ValueBinding<Boolean> active) {
        super(active);
        initialize();

        menu.add(new MenuItem(0, exitLabel));
    }

    public MenuView(ValueBinding<Boolean> active) {
        this("Exit", active); // constructor chaining
    }

    protected abstract void initialize();

    public void onMenuSelection(SelectionHandler handler) {
        this.selectionHandler = handler;
    }

    private void updateSelection(MenuItem item) {
        if (selectionHandler != null) {
            selectionHandler.handleMenuSelection(item);
        }
    }

    protected void handleSelectionUpdate(MenuItem item) {
        updateSelection(item);
    }

    @Override
    public void display(T params) {
        while (active.get()) {
            MenuItem item = menu.display();

            if (item == Menu.EXIT_MENU_ITEM) {
                close();
                break;
            } else {
                handleSelectionUpdate(item);
            }
        }
    }
}
