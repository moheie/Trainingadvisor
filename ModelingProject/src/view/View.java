package view;

import event.ExitHandler;
import util.Params;
import util.ValueBinding;

public abstract class View<T> {
    protected ValueBinding<Boolean> active;
    protected ExitHandler exitHandler;

    public void onExit(ExitHandler handler) {
        this.exitHandler = handler;
    }

    public void close() {
        if (exitHandler != null) {
            exitHandler.handleExit();
        }
    }

    //public abstract void display(Params params);
    public abstract void display(T params);

    protected View(ValueBinding<Boolean> active) {
        this.active = active;
    }
}
