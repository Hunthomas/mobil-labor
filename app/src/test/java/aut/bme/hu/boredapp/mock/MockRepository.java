package aut.bme.hu.boredapp.mock;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.model.BoredActivityEntity;
import aut.bme.hu.boredapp.repository.BoredRepository;

public class MockRepository extends BoredRepository {

    public static List<BoredActivityEntity> mockTable = new ArrayList<>();

    public MockRepository(Context context) {
        super(context);

        BoredActivityEntity mockEntity = new BoredActivityEntity();
        mockEntity.setActivity("Go cycling");
        mockEntity.setKey(1);
        mockEntity.setParticipants(10);
        mockEntity.setType("outdoor sport");
        mockTable.add(mockEntity);
    }

    @Override
    public void add(BoredActivityEntity activity) {
        mockTable.add(activity);
    }

    @Override
    public List<BoredActivityEntity> getAll() {
        return mockTable;
    }

    @Override
    public BoredActivityEntity getActivityById(int activityId) {
        return mockTable.stream().filter(boredActivityEntity -> boredActivityEntity.getKey() == activityId).findFirst().orElse(null);
    }

    @Override
    public void deleteById(int activityId) {
        mockTable.removeIf(boredActivityEntity -> boredActivityEntity.getKey() == activityId);
    }
}
