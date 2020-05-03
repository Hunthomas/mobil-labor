package aut.bme.hu.boredapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BoredActivity implements Serializable {
    @SerializedName("activity")
    @Expose
    private String activity;

    @SerializedName("accessibility")
    @Expose
    private float accessibility;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("participants")
    @Expose
    private int participants;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("key")
    @Expose
    private int key;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(float accessibility) {
        this.accessibility = accessibility;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
