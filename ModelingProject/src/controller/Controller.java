package controller;

import app.Session;
import event.NavigationHandler;
import util.Params;
import util.ValueBinding;

public abstract class Controller {
    protected ValueBinding<Boolean> isActive = new ValueBinding<>(false);
    private NavigationHandler navigationHandler;

    public abstract void render();
    protected abstract void initialize();

    protected void navigate(String path, Params params) {
        if (this.navigationHandler != null) {
            this.navigationHandler.handleNavigate(path, params);
        }
    }

    protected void navigate(String path) {
        navigate(path, new Params());
    }

    protected void navigateBackwards(Params params) {
        navigate("@back", params);
    }

    protected void navigateBackwards() {
        navigateBackwards(new Params());
    }

    public void onNavigate(NavigationHandler handler) {
        this.navigationHandler = handler;
    }

    public void setActive(boolean value) {
        isActive.set(value);
    }

    public Session getSession() {
        return Session.getInstance();
    }

    public Params getRequestParams() {
        return getSession().getRequestParams();
    }

    protected Controller() {
        initialize();
    }
}
