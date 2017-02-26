package com.developer.restapp.module;

import com.developer.restapp.interactor.Interactor;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class InteractorModule {

    @Provides
    public Interactor provideInteractor(Retrofit retrofit){
        return new Interactor(retrofit);
    }

}