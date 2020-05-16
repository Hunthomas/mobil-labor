package aut.bme.hu.boredapp.mock;

import java.io.IOException;

import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.network.BoredApi;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockBoredApi implements BoredApi {
    @Override
    public Call<BoredActivity> getActivity() {
        BoredActivity activity = new BoredActivity();
        activity.setActivity("Go cycling");
        activity.setKey(1);
        activity.setParticipants(10);
        activity.setType("outdoor sport");

        Call<BoredActivity> call = new Call<BoredActivity>() {
            @Override
            public Response<BoredActivity> execute() throws IOException {
                return Response.success(activity);
            }

            @Override
            public void enqueue(Callback<BoredActivity> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<BoredActivity> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }

            @Override
            public Timeout timeout() {
                return null;
            }
        };

        return call;
    }
}
