package com.thinkingintensors.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record Content(
        @PositiveOrZero
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
