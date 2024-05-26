package com.thinkingintensors.contentcalendar.controller;

import com.thinkingintensors.contentcalendar.config.ContentCalendarConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    private final ContentCalendarConfiguration properties;

    public Home(ContentCalendarConfiguration properties) {
        this.properties = properties;
    }

    @GetMapping("/home")
    public ContentCalendarConfiguration home() {
        return properties;
    }
}
