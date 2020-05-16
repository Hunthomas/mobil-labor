package aut.bme.hu.boredapp.ui.list;

import java.util.List;

import aut.bme.hu.boredapp.model.BoredActivity;

public interface ListScreen {
    void showActivities(List<BoredActivity> boredActivitites);

    void deleteActivity(int activityKey);

    void showDetails(int activityKey);
}
