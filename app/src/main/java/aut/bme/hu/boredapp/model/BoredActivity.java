package aut.bme.hu.boredapp.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BoredActivity implements Serializable {
    @SerializedName("activity")
    @Expose
    private String activity;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("participants")
    @Expose
    private int participants;

    @SerializedName("key")
    @Expose
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
