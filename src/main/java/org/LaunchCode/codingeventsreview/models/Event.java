package org.LaunchCode.codingeventsreview.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {

    private static int nextId = 1;

    private final int id;

    @Size(min=3, max=50, message="Name must be 3-50 characters.")
    @NotBlank(message="Name is required.")
    private String name;

    @Size(max=500, message="Description must be no more than 500 characters.")
    private String desc;

    @Email(message="Email must be a valid format.")
    @NotBlank(message="Email is required.")
    private String contactEmail;

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public Event(String name, String desc, String contactEmail) {
        this();
        this.name = name;
        this.desc = desc;
        this.contactEmail = contactEmail;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
