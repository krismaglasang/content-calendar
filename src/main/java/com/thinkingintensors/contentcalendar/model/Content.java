package com.thinkingintensors.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotEmpty @NotBlank
        String title,
        @NotBlank
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        @NotEmpty @NotBlank
        String url
) { }
