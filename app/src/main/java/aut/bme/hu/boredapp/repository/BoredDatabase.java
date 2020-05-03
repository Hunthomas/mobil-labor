package aut.bme.hu.boredapp.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import aut.bme.hu.boredapp.model.BoredActivityEntity;

@Database(entities = BoredActivityEntity.class, version = 1, exportSchema = false)
public abstract class BoredDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
