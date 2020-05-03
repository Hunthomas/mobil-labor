package aut.bme.hu.boredapp.mock;

import javax.inject.Singleton;

import aut.bme.hu.boredapp.network.BoredApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public BoredApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockBoredApi();
    }
}
