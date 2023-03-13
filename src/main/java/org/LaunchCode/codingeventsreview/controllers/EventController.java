package org.LaunchCode.codingeventsreview.controllers;

import org.LaunchCode.codingeventsreview.data.EventData;
import org.LaunchCode.codingeventsreview.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String renderCreateEventForm() {
        return "events/create";
    }

    // Processes form submitted at http://localhost:8080/events/create
    @PostMapping("/create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:/events";
    }

    // Renders http://localhost:8080/events/delete
    @GetMapping("/delete")
    public String renderDeleteEventForm(Model model) {
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

}
