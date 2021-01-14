package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.neighbourhoodnanny.child.Child;
import pl.sdacademy.neighbourhoodnanny.child.ChildRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/babysitter")
public class BabysitterController {
    BabysitterRepository babysitterRepository;
    ChildRepository childRepository;

    public BabysitterController(BabysitterRepository babysitterRepository, ChildRepository childRepository) {
        this.babysitterRepository = babysitterRepository;
        this.childRepository = childRepository;
    }

    @GetMapping
    public List<Babysitter> getAll() {
        return babysitterRepository.findAll();
    }

    @PostMapping
    public void add(@Validated @RequestBody Babysitter babysitter) {
        Babysitter babysitter1 = new Babysitter(babysitter.getFirstName(),babysitter.getLastName(),babysitter.getPhoneNumber(),babysitter.getEmail());
        Babysitter babysitter2 = new Babysitter("asdz", "asdqqq", "453654654", "qqq@aa");
        babysitterRepository.save(babysitter1);
        babysitterRepository.save(babysitter2);
    }

    @GetMapping("/{id}")
    public Babysitter getById(@PathVariable long id) {
        return babysitterRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        babysitterRepository.deleteById(id);
    }

    @DeleteMapping("/{id}/child/{childId}")
    public void deleteChild(@PathVariable long id, @PathVariable long childId) {
        Optional<Babysitter> babysitter = babysitterRepository.findById(id);
        Optional<Child> child = childRepository.findById(childId);
        if (babysitter.isPresent() && child.isPresent()) {
            babysitter.get().removeChild(child.get());
            babysitterRepository.save(babysitter.get());
        }
    }

    @PutMapping("/{id}")
    public void updateBabysitter(@Validated @RequestBody Babysitter newBabysitter, @PathVariable Long id) {
        babysitterRepository.findById(id).map(babysitter -> {
            babysitter.setFirstName(newBabysitter.getFirstName());
            babysitter.setLastName(newBabysitter.getLastName());
            babysitter.setChildren(newBabysitter.getChildren());
            babysitter.setEmail(newBabysitter.getEmail());
            babysitter.setPhoneNumber(newBabysitter.getPhoneNumber());
            babysitter.setEventList(newBabysitter.getEventList());
            return babysitterRepository.save(babysitter);
        });

    }
}
