package aut.bme.hu.boredapp.repository;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private Context context;

    public RepositoryModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public BoredRepository provideRepository(){
        throw new RuntimeException();
    }
}
