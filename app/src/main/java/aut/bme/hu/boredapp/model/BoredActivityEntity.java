package aut.bme.hu.boredapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BoredActivityEntity {

    public BoredActivityEntity(){}

    private String activity;
    private String type;
    private int participants;
    @PrimaryKey
    private int key;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
