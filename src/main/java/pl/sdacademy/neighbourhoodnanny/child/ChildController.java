package pl.sdacademy.neighbourhoodnanny.child;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.neighbourhoodnanny.babysitter.Babysitter;
import pl.sdacademy.neighbourhoodnanny.babysitter.BabysitterRepository;
import pl.sdacademy.neighbourhoodnanny.users.User;
import pl.sdacademy.neighbourhoodnanny.users.UserRepository;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/child")
public class ChildController {
    ChildRepository childRepository;
    BabysitterRepository babysitterRepository;
    UserRepository userRepository;

    public ChildController(ChildRepository childRepository, BabysitterRepository babysitterRepository, UserRepository userRepository) {
        this.childRepository = childRepository;
        this.babysitterRepository = babysitterRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Child> getAll() {
        return childRepository.findAll();
    }

    @PostMapping
    public Child add(@RequestBody Child child) {
        return childRepository.save(child);
    }

    @PostMapping("/addForLoggedUser")
    public Child addForLoggedUser(@RequestBody Child child) {
        Babysitter babysitter = getBabysitterFromLoggedUser();
        assert babysitter != null;
        Child savedChild = childRepository.save(child);
        babysitter.addChild(savedChild);
        babysitterRepository.save(babysitter);
        return savedChild;
    }

    @GetMapping("/{id}")
    public Child getById(@PathVariable long id) {
        return childRepository.findById(id).orElse(null);
    }

    @GetMapping("/getByParent/{id}")
    public List<Child> getByParentId(@PathVariable long id) {
        Babysitter babysitter = babysitterRepository.findById(id).orElse(null);
        assert babysitter != null;
        return babysitter.getChildren();
    }

    @GetMapping("/getByUser")
    public List<Child> getByUser() {
        Babysitter babysitter = getBabysitterFromLoggedUser();
        assert babysitter != null;
        return babysitter.getChildren();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Babysitter babysitter = getBabysitterFromLoggedUser();
        assert babysitter != null;
        Child child = childRepository.findById(id).orElse(null);
        babysitter.removeChild(child);
        System.out.println(System.lineSeparator() + babysitter + System.lineSeparator());
//        childRepository.deleteById(id);   //this was not only difficult, but also stupid
        babysitterRepository.save(babysitter);
    }

    @PutMapping("/{id}")
    public Child updateChild(@Validated @RequestBody Child newChild, @PathVariable Long id) {
        childRepository.findById(id).map(child -> {
            child.setFirstName(newChild.getFirstName());
            child.setLastName(newChild.getLastName());
            child.setBirthDate(newChild.getBirthDate());
            return childRepository.save(child);
        });
        return newChild;
    }

    private Babysitter getBabysitterFromLoggedUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);
        return babysitterRepository.findByUser(user).orElse(null);
    }
}
