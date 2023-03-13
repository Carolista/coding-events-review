package org.LaunchCode.codingeventsreview.models;

import java.util.Objects;

public class Event {

    private static int nextId = 1;

    private final int id;
    private String name;
    private String desc;

    public Event(String name, String desc) {
        this.id = nextId;
        this.name = name;
        this.desc = desc;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
