package aut.bme.hu.boredapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter presenter;
}
