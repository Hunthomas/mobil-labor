package aut.bme.hu.boredapp;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;

import aut.bme.hu.boredapp.network.NetworkModule;
import aut.bme.hu.boredapp.repository.RepositoryModule;

public class BoredApplication extends Application {

    public static BoredApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    public void initInjector(){
        injector = DaggerBoredApplicationComponent.builder()
                .repositoryModule(new RepositoryModule(this))
                .networkModule(new NetworkModule(this))
                .repositoryModule(new RepositoryModule(this))
                .build();
    }
}
