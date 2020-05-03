package aut.bme.hu.boredapp.ui.list;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.boredapp.model.BoredActivity;

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter presenter;

    @Override
    public void showActivities(List<BoredActivity> boredActivitites) {

    }
}
