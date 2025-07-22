package org.jopocode.jopofotoportfolio.PhotoShoot.dto;

import jakarta.validation.constraints.NotBlank;

public record SetMainPhotoRequest(
        @NotBlank(message = "Photo is required")
        String photoUuid
) {}
