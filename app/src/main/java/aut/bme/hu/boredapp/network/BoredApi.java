package aut.bme.hu.boredapp.network;

import aut.bme.hu.boredapp.model.BoredActivity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BoredApi {
    @GET("activity")
    Call<BoredActivity> getActivity();
}
