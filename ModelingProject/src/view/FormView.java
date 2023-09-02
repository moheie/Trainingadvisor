package view;

import event.SelectionHandler;
import event.SubmitHandler;
import util.ValueBinding;
import view.menu.MenuItem;

public abstract class FormView<SubmitType, ParamType> extends View<ParamType> {
    private SubmitHandler<SubmitType> submitHandler;

    public void onSubmit(SubmitHandler<SubmitType> handler) {
        this.submitHandler = handler;
    }

    protected void submit(SubmitType data) {
        if (submitHandler != null) {
            submitHandler.handleSubmit(data);
        }
    }

    protected FormView(ValueBinding<Boolean> active) {
        super(active);
    }
}
