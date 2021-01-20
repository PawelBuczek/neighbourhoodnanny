package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.neighbourhoodnanny.users.User;

import java.util.Optional;

public interface BabysitterRepository extends JpaRepository<Babysitter, Long> {
    Optional<Babysitter> findByEmail(String email);
    Optional<Babysitter> findByUser(User user);
}
