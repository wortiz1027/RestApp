package com.developer.restapp;

import android.app.Application;
import android.content.Context;

import com.developer.restapp.component.MyComponent;

public class PostApp extends Application {

    private PostAppComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        setGraph();
    }

    private void setGraph() {
        // TODO implementar el Dagger component
        component = DaggerPostAppComponent.builder()
                                    .appModule(new AppModule(this))
                                    .build();
    }

    public PostAppComponent getComponent() {
        return component;
    }

    public static PostApp getApp(Context context){
        return (PostApp) context.getApplicationContext();
    }

}