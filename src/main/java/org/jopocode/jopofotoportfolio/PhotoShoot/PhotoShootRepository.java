package org.jopocode.jopofotoportfolio.PhotoShoot;

import org.jopocode.jopofotoportfolio.PhotoShoot.entity.PhotoShoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoShootRepository extends JpaRepository<PhotoShoot, Integer> {
}
