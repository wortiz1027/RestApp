package com.developer.restapp.presenter;

import com.developer.restapp.interactor.Interactor;
import com.developer.restapp.ui.view.View;

import javax.inject.Inject;

public class Presenter implements IPresenter {

    View view;
    Interactor interactor;

    @Inject
    public Presenter(View view, Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onListPosts() {

    }
}