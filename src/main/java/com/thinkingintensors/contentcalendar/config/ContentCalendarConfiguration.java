package com.thinkingintensors.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "postgres")
public record ContentCalendarConfiguration(String username, String password) {
}
