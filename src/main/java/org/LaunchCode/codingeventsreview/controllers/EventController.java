package org.LaunchCode.codingeventsreview.controllers;

import jakarta.validation.Valid;
import org.LaunchCode.codingeventsreview.data.EventCategoryRepository;
import org.LaunchCode.codingeventsreview.data.EventRepository;
import org.LaunchCode.codingeventsreview.models.Event;
import org.LaunchCode.codingeventsreview.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    // Allow Spring to manage class using dependency injection
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    // Renders http://localhost:8080/events
    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer categoryId, Model model) {
        if (categoryId != null) {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if (result.isPresent()) {
                EventCategory category = result.get();
                model.addAttribute("events", category.getEvents());
            }
        } else {
            model.addAttribute("events", eventRepository.findAll());
        }
        return "events/index";
    }

    // Renders http://localhost:8080/events/create
    @GetMapping("/create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "events/create";
    }

    // Processes form submitted at http://localhost:8080/events/create
    @PostMapping("/create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("categories", eventCategoryRepository.findAll());
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    // Renders http://localhost:8080/events/delete
    @GetMapping("/delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("categories", eventRepository.findAll());
        return "events/delete";
    }

    // Processes form submitted at http://localhost:8080/events/delete
    @PostMapping("/delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:/events";
    }

    // Renders http://localhost:8080/events/edit/{id}
    @GetMapping("/edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId) {
        // Don't worry about this Optional syntax until chapter 18.3
        Optional<Event> eventWrapper = eventRepository.findById(eventId);
        if (eventWrapper.isPresent()) {
            Event event = eventWrapper.get();
            model.addAttribute("event", event);
            return "events/edit";
        }
        return "events/index";
    }

    // Processes form submitted at http://localhost:8080/events/edit
    @PostMapping("/edit")
    public String processEditEventForm(int eventId, String name, String description, String contactEmail) {
        // Don't worry about this Optional syntax until chapter 18.3
        Optional<Event> eventWrapper = eventRepository.findById(eventId);
        if (eventWrapper.isPresent()) {
            Event event = eventWrapper.get();
            event.setName(name);
            event.setDescription(description);
            event.setContactEmail(contactEmail);
            eventRepository.save(event);
        }
        return "redirect:/events";
    }
}
