package org.jopocode.jopofotoportfolio.PhotoShoot.dto;

import java.time.LocalDateTime;

public record UpdatePhotoShootRequest(
        // All optional for updates
        String name,
        String eventType,
        LocalDateTime date
        ) {
}
