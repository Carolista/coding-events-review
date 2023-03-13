package org.LaunchCode.codingeventsreview.controllers;

import jakarta.validation.Valid;
import org.LaunchCode.codingeventsreview.data.EventCategoryRepository;
import org.LaunchCode.codingeventsreview.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/event-categories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayCategories(Model model) {
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("/create")
    public String displayCreateEventCategoryForm(Model model) {
        model.addAttribute("category", new EventCategory());
        return "eventCategories/create";
    }

    @PostMapping("/create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory category, Errors errors) {
        if (errors.hasErrors()) {
            return "/create";
        }
        eventCategoryRepository.save(category);
        return "redirect:/event-categories";
    }
}
