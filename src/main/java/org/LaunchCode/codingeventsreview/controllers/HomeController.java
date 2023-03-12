package org.LaunchCode.codingeventsreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping public String displayHomePage() {
        return "index";
    }
}
