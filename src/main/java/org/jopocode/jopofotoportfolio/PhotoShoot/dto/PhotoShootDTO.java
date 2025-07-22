package org.jopocode.jopofotoportfolio.PhotoShoot.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PhotoShootDTO(
        Integer id,
        String name,
        String eventType,
        LocalDateTime date,
        String mainPhoto,        // S3 UUID as String
        List<String> photoList ) { }
