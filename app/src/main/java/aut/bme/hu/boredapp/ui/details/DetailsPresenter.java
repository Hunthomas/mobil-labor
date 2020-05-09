package aut.bme.hu.boredapp.ui.details;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.interactor.BoredInteractor;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    BoredInteractor interactor;

    @Inject
    public DetailsPresenter(BoredInteractor interactor){
        this.interactor = interactor;
    }

    public BoredActivity getActivity() throws IOException {
        return interactor.getBoredActivity();
    }
}
