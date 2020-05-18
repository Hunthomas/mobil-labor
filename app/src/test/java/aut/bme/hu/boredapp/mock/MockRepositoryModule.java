package aut.bme.hu.boredapp.mock;

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.boredapp.repository.BoredRepository;
import aut.bme.hu.boredapp.repository.RepositoryModule;
import dagger.Module;
import dagger.Provides;

@Module
public class MockRepositoryModule extends RepositoryModule {
    Context context;

    public MockRepositoryModule(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    @Singleton
    @Provides
    public BoredRepository provideRepository() {
        return new MockRepository(context);
    }
}
