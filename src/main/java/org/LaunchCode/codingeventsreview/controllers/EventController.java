package org.LaunchCode.codingeventsreview.controllers;

import org.LaunchCode.codingeventsreview.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private static final List<Event> events = new ArrayList<>();

    // Renders http://localhost:8080/events
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "events/index";
    }

    // Renders http://localhost:8080/events/create
    @GetMapping("/create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // Processes form submitted from http://localhost:8080/events/create
    @PostMapping("/create")
    public String processCreateEventForm(@RequestParam String eventName, String eventDesc) {
        events.add(new Event(eventName, eventDesc));
        return "redirect:/events";
    }

}
