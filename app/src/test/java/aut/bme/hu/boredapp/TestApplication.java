package aut.bme.hu.boredapp;

import aut.bme.hu.boredapp.mock.MockNetworkModule;
import aut.bme.hu.boredapp.mock.MockRepositoryModule;

public class TestApplication extends BoredApplication {

    @Override
    public void initInjector() {
        injector = DaggerBoredApplicationComponent.builder()
                .repositoryModule(new MockRepositoryModule(this))
                .networkModule(new MockNetworkModule(this))
                .build();
    }
}
