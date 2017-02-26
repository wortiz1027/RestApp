package com.developer.restapp.io;

import com.developer.restapp.io.model.PostsResponse;
import com.developer.restapp.util.Constants;

import retrofit2.http.GET;
import io.reactivex.Observable;;

public interface ApiService {

    @GET(Constants.OPERATION)
    Observable<PostsResponse> loadPost();

}