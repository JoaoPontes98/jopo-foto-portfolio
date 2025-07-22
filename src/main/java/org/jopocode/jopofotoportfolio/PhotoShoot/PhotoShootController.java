package org.jopocode.jopofotoportfolio.PhotoShoot;

import org.jopocode.jopofotoportfolio.PhotoShoot.dto.AddPhotoRequest;
import org.jopocode.jopofotoportfolio.PhotoShoot.dto.CreatePhotoShootRequest;
import org.jopocode.jopofotoportfolio.PhotoShoot.dto.PhotoShootDTO;
import org.jopocode.jopofotoportfolio.PhotoShoot.dto.SetMainPhotoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/photoShoots")
public class PhotoShootController {

    private final PhotoShootService photoShootService;

    public PhotoShootController(PhotoShootService photoShootService){
        this.photoShootService = photoShootService;
    }

    @GetMapping
    public List<PhotoShootDTO> getPhotoShoots() {return photoShootService.getAllPhotoShoots();}

    @GetMapping("{photoShootId}")
    public PhotoShootDTO getPhotoShoot(
            @PathVariable("photoShootId") Integer photoShootId
    ) {
        return photoShootService.getPhotoShoot(photoShootId);
    }

    @PostMapping
    public ResponseEntity<PhotoShootDTO> createPhotoShoot(@RequestBody CreatePhotoShootRequest request) {
        PhotoShootDTO createdPhotoShoot = photoShootService.createPhotoShoot(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhotoShoot);
    }

    @PostMapping("/{photoShootId}/photos")
    public ResponseEntity<PhotoShootDTO> addPhoto(
            @PathVariable Integer photoShootId,
            @RequestBody AddPhotoRequest request) {
        PhotoShootDTO updated = photoShootService.addPhotoToShoot(photoShootId, request.photoUuid());
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{photoShootId}/main-photo")
    public ResponseEntity<PhotoShootDTO> setMainPhoto(
            @PathVariable Integer photoShootId,
            @RequestBody SetMainPhotoRequest request) {
        PhotoShootDTO updated = photoShootService.setMainPhoto(photoShootId, request.photoUuid());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{photoShootId}/photos/{photoUuid}")
    public ResponseEntity<PhotoShootDTO> removePhoto(
            @PathVariable Integer photoShootId,
            @PathVariable String photoUuid) {
        PhotoShootDTO updated = photoShootService.removePhotoFromShoot(photoShootId, photoUuid);
        return ResponseEntity.ok(updated);
    }
}
