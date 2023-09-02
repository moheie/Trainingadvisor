package controller;

import app.Session;
import entity.user.User;
import entity.user.UserDetails;
import event.SelectionHandler;
import util.Params;
import view.TraineeView;
import view.menu.MenuItem;

public class TraineeController extends DefaultViewController<TraineeView> implements SelectionHandler {
    @Override
    protected void initialize() {
        view = new TraineeView(isActive);

        view.onMenuSelection(this);
        view.onExit(this);
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
                navigate("/account/manage");
                break;
            case 2:
                navigate("/library");
                break;
            case 3:
                displayAccount();
                break;
            case 4:
                navigate("/course/search");
                break;
            case 5:
                navigate("/course/enroll");
                break;
            case 6:
                navigate("/help");
                break;
        }
    }

    private void displayAccount() {
        Session session = getSession();
        User user = session.getUser();

        user.display();
    }
}
