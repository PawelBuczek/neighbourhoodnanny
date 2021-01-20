package pl.sdacademy.neighbourhoodnanny.users;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.neighbourhoodnanny.babysitter.Babysitter;
import pl.sdacademy.neighbourhoodnanny.babysitter.BabysitterRepository;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
    private BabysitterRepository babysitterRepository;
    private UserRepository userRepository;

    public UserController(BabysitterRepository babysitterRepository, UserRepository userRepository) {
        this.babysitterRepository = babysitterRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public LoggedUserDto login() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow()
                .getAuthority();
        return new LoggedUserDto(username, role);
    }

    @PostMapping("/user")
    public UserBabysitterDTO addUserWithBabysitter(@Validated @RequestBody UserBabysitterDTO userBabysitterDTO) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow()
                .getAuthority();
        User user = new User(userBabysitterDTO.getUsername(), userBabysitterDTO.getPassword(), role);
        Babysitter babysitter = new Babysitter(user, userBabysitterDTO.getFirstName(), userBabysitterDTO.getLastName(), userBabysitterDTO.getPhoneNumber(), userBabysitterDTO.getEmail());
        userRepository.save(user);
        babysitterRepository.save(babysitter);
        return userBabysitterDTO;
    }
}

