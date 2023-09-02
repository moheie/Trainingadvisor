package controller;

import event.SelectionHandler;
import util.Params;
import view.MainView;
import view.menu.MenuItem;

public class MainController extends DefaultViewController<MainView> implements SelectionHandler {
    @Override
    protected void initialize() {
        view = new MainView(isActive);

        view.onMenuSelection(this);
        view.onExit(this);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                // help desk
                navigate("/help");
                break;
            case 2:
                // sign in
                navigate("/signIn");
                break;
            case 3:
                // sign up
                navigate("/signUp");
                break;
        }
    }
}
