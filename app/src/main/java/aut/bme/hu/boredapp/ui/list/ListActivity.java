package aut.bme.hu.boredapp.ui.list;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import aut.bme.hu.boredapp.model.BoredActivitites;

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter presenter;

    @Override
    public void showActivities(BoredActivitites boredActivitites) {

    }
}
