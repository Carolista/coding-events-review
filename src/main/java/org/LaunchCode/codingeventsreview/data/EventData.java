package org.LaunchCode.codingeventsreview.data;

import org.LaunchCode.codingeventsreview.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // Data structure to store events
    private static final Map<Integer, Event> events = new HashMap<>();

    // Get all events
    public static Collection<Event> getAll() {
        return events.values();
    }

    // Get a single event
    public static Event getById(int id) {
        return events.get(id);
    }

    // Add event
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    // Remove event
    public static void remove(int id) {
        events.remove(id);
    }
}
