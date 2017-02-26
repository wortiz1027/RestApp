package com.developer.restapp.interactor;

import com.developer.restapp.io.ApiService;
import com.developer.restapp.io.callback.PostServerCallback;

import javax.inject.Inject;

import retrofit2.Retrofit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Interactor {

    public Retrofit retrofit;

    @Inject
    public Interactor(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void posts(final PostServerCallback callback){
        retrofit.create(ApiService.class)
                .loadPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postsResponse -> {
                                             callback.onPostFound(postsResponse.getPosts());
                                            },
                           throwable -> {
                                         callback.onFailedLoadPost();
                                        }
                          );
    }

}