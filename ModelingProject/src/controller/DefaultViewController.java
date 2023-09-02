package controller;

import util.Params;
import view.View;

public abstract class DefaultViewController<ViewType extends View<Void>> extends ViewController<Void, ViewType> {
    @Override
    protected Void buildViewParams(Params params) {
        return null;
    }
}
