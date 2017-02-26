package com.developer.restapp.module;

import com.developer.restapp.interactor.Interactor;
import com.developer.restapp.presenter.IPresenter;
import com.developer.restapp.presenter.Presenter;
import com.developer.restapp.ui.view.View;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    private View view;

    public PostModule(View view) {
        this.view = view;
    }

    @Provides
    public View provideView(){
        return view;
    }

    @Provides
    public IPresenter providePresenter(View view, Interactor interactor){
        return new Presenter(view, interactor);
    }

}