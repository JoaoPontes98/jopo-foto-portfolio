package org.jopocode.jopofotoportfolio.PhotoShoot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record CreatePhotoShootRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Event type is required")
        String eventType,

        @NotNull(message = "Date is required")
        LocalDateTime date,

        String mainPhoto,        // Optional on creation
        List<String> photoList   // Optional on creation, defaults to empty list
) {}