package aut.bme.hu.boredapp.ui.details;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.BoredApplication;
import aut.bme.hu.boredapp.R;
import aut.bme.hu.boredapp.model.BoredActivity;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    @Inject
    DetailsPresenter presenter;

    TextView activityNameTv;
    TextView activityTypeTv;
    TextView participantsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        BoredApplication.injector.inject(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        activityNameTv = findViewById(R.id.activityNameTv);
        activityTypeTv = findViewById(R.id.activityTypeTv);
        participantsTv = findViewById(R.id.participantsTv);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            loadFromDb((int)extras.get("activityId"));
        } else{
            loadFromNetwork();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    public void findNewActivity(View view){
        loadFromNetwork();
    }

    private void loadFromNetwork(){
        try {
            presenter.getNewActivity();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromDb(int key){
        presenter.getFromDb(key);
    }

    @Override
    public void showBoredActivity(BoredActivity activity) {
        activityNameTv.setText(activity.getActivity());
        participantsTv.setText(String.valueOf(activity.getParticipants()));
        activityTypeTv.setText(activity.getType());
    }
}
