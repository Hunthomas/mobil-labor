package aut.bme.hu.boredapp;

import javax.inject.Singleton;

import aut.bme.hu.boredapp.network.NetworkModule;
import aut.bme.hu.boredapp.repository.RepositoryModule;
import aut.bme.hu.boredapp.ui.UIModule;
import aut.bme.hu.boredapp.ui.details.DetailsActivity;
import aut.bme.hu.boredapp.ui.list.ListActivity;
import aut.bme.hu.boredapp.ui.main.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, RepositoryModule.class})
public interface BoredApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ListActivity mainActivity);
    void inject(DetailsActivity mainActivity);
}
