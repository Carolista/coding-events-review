package org.LaunchCode.codingeventsreview.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Event extends AbstractEntity {

    @Size(min=3, max=50, message="Name must be 3-50 characters.")
    @NotBlank(message="Name is required.")
    private String name;

    @Size(max=500, message="Description must be no more than 500 characters.")
    private String description;

    @Email(message="Email must be a valid format.")
    @NotBlank(message="Email is required.")
    private String contactEmail;

    private EventType type;

    public Event() {}

    public Event(String name, String description, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

}
