package org.jopocode.jopofotoportfolio.exception;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Error response for validation failures
 */
public record ValidationErrorResponse(
        String errorCode,
        String message,
        LocalDateTime timestamp,
        int status,
        Map<String, String> fieldErrors
) {}