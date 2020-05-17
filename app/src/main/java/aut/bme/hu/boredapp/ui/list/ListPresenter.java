package aut.bme.hu.boredapp.ui.list;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import aut.bme.hu.boredapp.interactor.BoredInteractor;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.model.BoredActivityEntity;
import aut.bme.hu.boredapp.repository.BoredRepository;
import aut.bme.hu.boredapp.ui.Presenter;

public class ListPresenter extends Presenter<ListScreen> {
    @Inject
    BoredRepository repository;

    @Inject
    BoredInteractor interactor;

    @Inject
    public ListPresenter(BoredRepository boredRepository, BoredInteractor boredInteractor) {
        this.repository = boredRepository;
        this.interactor = boredInteractor;
    }

    public void getAll(){
        List<BoredActivityEntity> a = repository.getAll();
        screen.showActivities(a.stream().map(entity -> {
            BoredActivity activity = new BoredActivity();
            activity.setActivity(entity.getActivity());
            activity.setKey(entity.getKey());
            activity.setParticipants(entity.getParticipants());
            activity.setType(entity.getType());
            return activity;
        }).collect(Collectors.toList()));
    }

    public void deleteActivityById(int activityKey){
        repository.deleteById(activityKey);
    }
}
