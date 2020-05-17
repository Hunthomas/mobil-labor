package aut.bme.hu.boredapp.repository;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.boredapp.BoredApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private Context context;

    public RepositoryModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public BoredRepository provideRepository(){
        return new BoredRepository(context);
    }
}
