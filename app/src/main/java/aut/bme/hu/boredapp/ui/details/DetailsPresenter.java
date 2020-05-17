package aut.bme.hu.boredapp.ui.details;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.interactor.BoredInteractor;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.model.BoredActivityEntity;
import aut.bme.hu.boredapp.repository.BoredRepository;
import aut.bme.hu.boredapp.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    BoredInteractor interactor;
    BoredRepository repository;

    @Inject
    public DetailsPresenter(BoredInteractor interactor, BoredRepository repository){
        this.interactor = interactor;
        this.repository = repository;
    }

    public void getNewActivity() throws IOException {
        BoredActivity activity = interactor.getBoredActivity();
        screen.showBoredActivity(activity);
        storeActivity(activity);
    }

    public void getFromDb(int key){
        BoredActivityEntity entity = repository.getActivityById(key);
        BoredActivity model = new BoredActivity();
        model.setType(entity.getType());
        model.setParticipants(entity.getParticipants());
        model.setKey(entity.getKey());
        model.setActivity(entity.getActivity());
        screen.showBoredActivity(model);
    }

    private void storeActivity(BoredActivity activity){
        BoredActivityEntity entity = new BoredActivityEntity();
        entity.setActivity(activity.getActivity());
        entity.setParticipants(activity.getParticipants());
        entity.setType(activity.getType());
        entity.setKey(activity.getKey());
        repository.add(entity);
    }
}
