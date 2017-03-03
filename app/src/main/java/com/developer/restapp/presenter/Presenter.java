package com.developer.restapp.presenter;

import android.util.Log;

import com.developer.restapp.common.BasePresenter;
import com.developer.restapp.domain.Post;
import com.developer.restapp.interactor.Interactor;
import com.developer.restapp.io.callback.PostServerCallback;
import com.developer.restapp.ui.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

public class Presenter extends BasePresenter implements PostServerCallback {

    View view;
    Interactor interactor;

    @Inject
    public Presenter(View view, Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void loadPost(){
        interactor.posts(this);
    }

    @Override
    public void onPostFound(ArrayList<Post> posts) {
        Log.d("PRESENTER", "onPostFound: " + posts.size());
        view.displayPosts(posts);
    }

    @Override
    public void onFailedLoadPost() {
        Log.d("PRESENTER", "onFailedLoadPost");
        view.displayErrorPost();
    }

    @Override
    public void onNetworkError() {
        view.displayNetworkError();
    }

    @Override
    public void onServerError() {
        view.displayServerError();
    }

}