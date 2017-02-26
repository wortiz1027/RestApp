package com.developer.restapp.io.model;

import com.developer.restapp.domain.Post;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostsResponse {

    @SerializedName("posts")
    private Response response;

    public ArrayList<Post> getPosts(){
        return response.posts;
    }

    private class Response {
        @SerializedName("items")
        ArrayList<Post> posts;
    }

}