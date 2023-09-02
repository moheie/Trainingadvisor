package app;

import database.HelpDeskDB;
import entity.user.User;
import util.Params;

public class Session {
    private static Session instance = null;

    public static Session getInstance() { // static method to get instance
        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }

    private User user;
    private Params requestParams;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Params getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Params requestParams) {
        this.requestParams = requestParams;
    }
}
