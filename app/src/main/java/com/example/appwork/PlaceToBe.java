package com.example.appwork;

import android.graphics.drawable.Drawable;

import java.util.Objects;

public class PlaceToBe {

    private int id;
    private String titre;
    private long lat;
    private long lon;
    private Drawable drawable;
    private String description;

    public PlaceToBe(int id, String titre, long lat, long lon, Drawable drawable, String description) {
        this.id = id;
        this.titre = titre;
        this.lat = lat;
        this.lon = lon;
        this.drawable = drawable;
        this.description = description;
    }

    public PlaceToBe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
