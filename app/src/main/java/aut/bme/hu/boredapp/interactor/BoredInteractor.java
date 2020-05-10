package aut.bme.hu.boredapp.interactor;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.network.BoredApi;
import retrofit2.Call;

public class BoredInteractor {
    BoredApi boredApi;

    @Inject
    public BoredInteractor(BoredApi boredApi) {
        this.boredApi = boredApi;
    }

    public BoredActivity getBoredActivity() throws IOException {
        Call<BoredActivity> boredActivityCall = boredApi.getActivity();
        return boredActivityCall.execute().body();
    }


}

