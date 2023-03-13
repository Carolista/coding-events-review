package org.LaunchCode.codingeventsreview.models;

import jakarta.persistence.Entity;

@Entity
public class EventCategory extends AbstractEntity {

    private String name;

    public EventCategory() {}

    public EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
