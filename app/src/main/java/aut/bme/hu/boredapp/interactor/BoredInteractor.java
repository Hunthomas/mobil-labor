package aut.bme.hu.boredapp.interactor;

import javax.inject.Inject;

import aut.bme.hu.boredapp.network.BoredApi;

public class BoredInteractor {
    BoredApi boredApi;

    @Inject
    public BoredInteractor(BoredApi boredApi) {
        this.boredApi = boredApi;
    }

    public void getBoredActivity(){

    }
}

