package com.tourplanner.dto;

import java.io.Serializable;

public class Attraction implements Serializable {
    private int id;
    private String attractionName;
    private String attractionType;
    private boolean selected;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(String attractionType) {
        this.attractionType = attractionType;
    }

    public Attraction(int id, String attractionName,String attractionType) {
        this.id = id;
        this.attractionName = attractionName;
        this.attractionType = attractionType;
    }

    public int getId() {
        return id;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }
}
