package controller;

import event.ExitHandler;
import util.Params;
import view.View;

public abstract class ViewController<ViewParamsType, ViewType extends View<ViewParamsType>> extends Controller implements ExitHandler {
    protected ViewType view;

    protected abstract ViewParamsType buildViewParams(Params params);

    @Override
    public void handleExit() {
        navigateBackwards();
    }

    @Override
    public void render() {
        ViewParamsType viewParams = buildViewParams(getRequestParams());

        view.display(viewParams);
    }
}
