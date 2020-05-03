package aut.bme.hu.boredapp.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.model.BoredActivityEntity;

public class BoredRepository {
    @Inject
    Context context;

    private BoredDatabase boredDatabase;

    public BoredRepository(){
        boredDatabase = Room.databaseBuilder(context, BoredDatabase.class, "db_activity").build();
    }

    public void add(final BoredActivityEntity activity){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                boredDatabase.daoAccess().insertActivity(activity);
                return null;
            }
        }.execute();
    }

    public List<BoredActivityEntity> getAll() {
        try {
            return new AsyncTask<Void, Void, List<BoredActivityEntity>>(){
                @Override
                protected List<BoredActivityEntity> doInBackground(Void... voids){
                    return boredDatabase.daoAccess().getAllActivities();
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(final BoredActivityEntity boredActivity) {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                boredDatabase.daoAccess().deleteActivity(boredActivity);
                return null;
            }
        }.execute();
    }
}
