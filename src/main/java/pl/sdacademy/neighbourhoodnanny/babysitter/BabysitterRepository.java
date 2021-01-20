package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BabysitterRepository extends JpaRepository<Babysitter, Long> {
    Optional<Babysitter> findByEmail(String email);
}
