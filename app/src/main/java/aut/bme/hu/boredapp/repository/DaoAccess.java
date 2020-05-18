package aut.bme.hu.boredapp.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import aut.bme.hu.boredapp.model.BoredActivityEntity;

@Dao
public interface DaoAccess {
    @Insert
    Long insertActivity(BoredActivityEntity boredActivity);

    @Query("SELECT * FROM BoredActivityEntity")
    List<BoredActivityEntity> getAllActivities();

    @Query("SELECT * FROM BoredActivityEntity WHERE `key` = :activityId")
    BoredActivityEntity getActivityById(int activityId);

    @Delete
    void deleteActivity(BoredActivityEntity boredActivity);
}
