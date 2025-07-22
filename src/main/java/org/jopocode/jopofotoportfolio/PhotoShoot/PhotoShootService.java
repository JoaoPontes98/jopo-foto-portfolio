package org.jopocode.jopofotoportfolio.PhotoShoot;

import org.jopocode.jopofotoportfolio.PhotoShoot.dto.CreatePhotoShootRequest;
import org.jopocode.jopofotoportfolio.PhotoShoot.dto.PhotoShootDTO;
import org.jopocode.jopofotoportfolio.PhotoShoot.entity.PhotoShoot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoShootService {

    private final PhotoShootRepository photoShootRepository;

    public PhotoShootService(PhotoShootRepository photoShootRepository) {
        this.photoShootRepository = photoShootRepository;
    }

    public PhotoShootDTO createPhotoShoot(CreatePhotoShootRequest request) {
        PhotoShoot photoShoot = new PhotoShoot();
        photoShoot.setName(request.name());
        photoShoot.setEventType(request.eventType());
        photoShoot.setDate(request.date());
        photoShoot.setMainPhoto(request.mainPhoto());
        photoShoot.setPhotoList(request.photoList() != null ?
                new ArrayList<>(request.photoList()) : new ArrayList<>());

        PhotoShoot saved = photoShootRepository.save(photoShoot);
        return convertToDTO(saved);
    }

    public List<PhotoShootDTO> getAllPhotoShoots() {
        return photoShootRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public PhotoShootDTO getPhotoShoot(Integer photoShootId) {
        PhotoShoot photoShoot = photoShootRepository.findById(photoShootId)
                .orElseThrow(() -> new PhotoShootNotFoundException(
                        "PhotoShoot not found with ID: " + photoShootId,
                        photoShootId
                ));
        return convertToDTO(photoShoot);
    }

    public PhotoShootDTO addPhotoToShoot(Integer shootId, String photoUuid) {
        PhotoShoot photoShoot = photoShootRepository.findById(shootId)
                .orElseThrow(() -> new PhotoShootNotFoundException(
                        "PhotoShoot not found with ID: " + shootId,
                        shootId
                ));

        photoShoot.getPhotoList().add(photoUuid);
        PhotoShoot saved = photoShootRepository.save(photoShoot);
        return convertToDTO(saved);
    }

    public PhotoShootDTO setMainPhoto(Integer shootId, String photoUuid) {
        PhotoShoot photoShoot = photoShootRepository.findById(shootId)
                .orElseThrow(() -> new PhotoShootNotFoundException(
                        "PhotoShoot not found with ID: " + shootId,
                        shootId
                ));

        photoShoot.setMainPhoto(photoUuid);
        PhotoShoot saved = photoShootRepository.save(photoShoot);
        return convertToDTO(saved);
    }

    public PhotoShootDTO removePhotoFromShoot(Integer photoShootId, String photoUuid) {
        PhotoShoot photoShoot = photoShootRepository.findById(photoShootId)
                .orElseThrow(() -> new PhotoShootNotFoundException(
                        "PhotoShoot not found with ID: " + photoShootId,
                        photoShootId
                ));

        photoShoot.getPhotoList().remove(photoUuid);

        // If removed photo was the main photo, clear it
        if (photoUuid.equals(photoShoot.getMainPhoto())) {
            photoShoot.setMainPhoto(null);
        }

        PhotoShoot saved = photoShootRepository.save(photoShoot);
        return convertToDTO(saved);
    }

    private PhotoShootDTO convertToDTO(PhotoShoot photoShoot) {
        return new PhotoShootDTO(
                photoShoot.getId(),
                photoShoot.getName(),
                photoShoot.getEventType(),
                photoShoot.getDate(),
                photoShoot.getMainPhoto(),
                new ArrayList<>(photoShoot.getPhotoList())
        );
    }
}