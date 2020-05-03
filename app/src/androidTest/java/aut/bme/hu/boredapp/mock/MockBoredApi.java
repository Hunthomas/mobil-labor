package aut.bme.hu.boredapp.mock;

import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.network.BoredApi;
import retrofit2.Call;

public class MockBoredApi implements BoredApi {
    @Override
    public Call<BoredActivity> getActivity() {
        return null;
    }
}
