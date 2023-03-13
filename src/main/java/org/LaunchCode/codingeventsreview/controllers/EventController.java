package org.LaunchCode.codingeventsreview.controllers;

import jakarta.validation.Valid;
import org.LaunchCode.codingeventsreview.data.EventData;
import org.LaunchCode.codingeventsreview.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    // Renders http://localhost:8080/events
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    // Renders http://localhost:8080/events/create
    @GetMapping("/create")
    public String displayCreateEventForm() {
        return "events/create";
    }

    // Processes form submitted at http://localhost:8080/events/create
    @PostMapping("/create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors) {
        if (errors.hasErrors()) {
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:/events";
    }

    // Renders http://localhost:8080/events/delete
    @GetMapping("/delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    // Processes form submitted at http://localhost:8080/events/delete
    @PostMapping("/delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";
    }

    // Renders http://localhost:8080/events/edit/{id}
    @GetMapping("/edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId) {
        model.addAttribute("event", EventData.getById(eventId));
        return "events/edit";
    }

    // Processes form submitted at http://localhost:8080/events/edit
    @PostMapping("/edit")
    public String processEditEventForm(int eventId, String name, String desc, String contactEmail) {
        Event event = EventData.getById(eventId);
        event.setName(name);
        event.setDesc(desc);
        event.setContactEmail(contactEmail);
        return "redirect:/events";
    }
}
