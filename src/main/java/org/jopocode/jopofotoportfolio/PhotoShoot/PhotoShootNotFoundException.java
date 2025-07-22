package org.jopocode.jopofotoportfolio.PhotoShoot;

import org.jopocode.jopofotoportfolio.PhotoShoot.entity.PhotoShoot;
/**
 * Exception thrown when a PhotoShoot is not found in the system.
 * This is a runtime exception that should be handled by the global exception handler.
 */
public class PhotoShootNotFoundException extends RuntimeException {

    private final Integer photoShootId;

    public PhotoShootNotFoundException(String message) {
        super(message);
        this.photoShootId = null;
    }

    public PhotoShootNotFoundException(String message, Integer photoShootId) {
        super(message);
        this.photoShootId = photoShootId;
    }

    public PhotoShootNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.photoShootId = null;
    }

    public PhotoShootNotFoundException(String message, Integer photoShootId, Throwable cause) {
        super(message, cause);
        this.photoShootId = photoShootId;
    }

    public Integer getPhotoShootId() {
        return photoShootId;
    }

    @Override
    public String toString() {
        if (photoShootId != null) {
            return String.format("PhotoShootNotFoundException: %s (ID: %d)", getMessage(), photoShootId);
        }
        return String.format("PhotoShootNotFoundException: %s", getMessage());
    }
}