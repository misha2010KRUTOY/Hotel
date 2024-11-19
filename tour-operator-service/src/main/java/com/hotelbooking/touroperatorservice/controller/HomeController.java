package com.hotelbooking.touroperatorservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "tourList"; // Возвращает имя JSP страницы для списка туров
    }
}
