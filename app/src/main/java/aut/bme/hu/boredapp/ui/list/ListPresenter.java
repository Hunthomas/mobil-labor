package aut.bme.hu.boredapp.ui.list;

import javax.inject.Inject;

import aut.bme.hu.boredapp.interactor.BoredInteractor;
import aut.bme.hu.boredapp.repository.BoredRepository;
import aut.bme.hu.boredapp.ui.Presenter;

public class ListPresenter extends Presenter<ListScreen> {
    BoredRepository repository;
    BoredInteractor interactor;

    @Inject
    public ListPresenter(BoredRepository boredRepository, BoredInteractor boredInteractor) {
        this.repository = boredRepository;
        this.interactor = boredInteractor;
    }
}
