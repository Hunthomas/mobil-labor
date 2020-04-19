package aut.bme.hu.boredapp.network;

import android.content.Context;

import java.io.UncheckedIOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {
    private Context context;

    public NetworkModule(Context context) {
        this.context = context;
    }
    @Provides
    @Singleton
    public BoredApi provideBoredApi()  {
        throw new RuntimeException();
    }
}
