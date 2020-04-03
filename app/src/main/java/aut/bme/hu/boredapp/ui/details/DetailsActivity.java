package aut.bme.hu.boredapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import aut.bme.hu.boredapp.model.BoredActivity;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    @Inject
    DetailsPresenter presenter;
    
    @Override
    public void showBoredActivity(BoredActivity activity) {

    }
}
