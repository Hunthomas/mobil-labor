package aut.bme.hu.boredapp.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.boredapp.BoredApplication;
import aut.bme.hu.boredapp.R;
import aut.bme.hu.boredapp.model.BoredActivity;

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<BoredActivity> activities = new ArrayList<BoredActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        BoredApplication.injector.inject(this);

        recyclerView = findViewById(R.id.activitiesRv);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ActivityAdapter(activities);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        presenter.getAll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showActivities(List<BoredActivity> boredActivitites) {
        activities.clear();
        activities.addAll(boredActivitites);
        adapter.notifyDataSetChanged();
    }
}
