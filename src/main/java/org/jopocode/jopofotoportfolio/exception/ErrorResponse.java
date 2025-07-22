package org.jopocode.jopofotoportfolio.exception;

import java.time.LocalDateTime;

/**
 * Standard error response for API exceptions
 */
public record ErrorResponse(
        String errorCode,
        String message,
        LocalDateTime timestamp,
        int status
) {}