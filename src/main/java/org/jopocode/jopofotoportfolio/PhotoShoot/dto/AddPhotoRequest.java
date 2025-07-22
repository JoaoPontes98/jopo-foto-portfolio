package org.jopocode.jopofotoportfolio.PhotoShoot.dto;

import jakarta.validation.constraints.NotBlank;

public record AddPhotoRequest(
        @NotBlank(message = "Photo UUID is required")
        String photoUuid
) {}