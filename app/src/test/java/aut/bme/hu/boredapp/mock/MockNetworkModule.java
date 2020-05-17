package aut.bme.hu.boredapp.mock;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.boredapp.network.BoredApi;
import aut.bme.hu.boredapp.network.NetworkModule;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule extends NetworkModule {
    public MockNetworkModule(Context context) {
        super(context);
    }

    @Override
    @Provides
    @Singleton
    public BoredApi provideBoredApi(Retrofit.Builder retrofitBuilder) {
        return new MockBoredApi();
    }
}
