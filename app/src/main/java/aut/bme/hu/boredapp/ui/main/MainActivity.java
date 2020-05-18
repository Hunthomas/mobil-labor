package aut.bme.hu.boredapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;


import com.google.firebase.analytics.FirebaseAnalytics;

import aut.bme.hu.boredapp.BoredApplication;
import aut.bme.hu.boredapp.R;
import aut.bme.hu.boredapp.ui.details.DetailsActivity;
import aut.bme.hu.boredapp.ui.list.ListActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BoredApplication.injector.inject(this);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "MainActivity");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        throw new RuntimeException();
    }

    public void showBoredActivity(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void showHistory(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
