package controller;

import event.SelectionHandler;
import util.Params;
import view.AdminView;
import view.menu.MenuItem;

public class AdminController extends DefaultViewController<AdminView> implements SelectionHandler {
    @Override
    protected void initialize() {
        view = new AdminView(isActive);

        view.onExit(this);
        view.onMenuSelection(this);
    }

    @Override
    public void handleExit() {
        Params params = new Params();

        params.put("offset", 1);
        navigateBackwards(params);
    }

    @Override
    public void handleMenuSelection(MenuItem item) {
        switch (item.getId()) {
            case 1:
                navigate("/admin/manageAccounts");
                break;
            case 2:
                navigate("/admin/manageCourses");
                break;
            case 3:
                navigate("/admin/analytics");
                break;
            case 4:
                navigate("/help");
                break;
        }
    }
}
