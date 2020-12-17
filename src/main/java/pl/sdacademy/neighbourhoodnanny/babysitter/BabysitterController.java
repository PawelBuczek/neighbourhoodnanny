package pl.sdacademy.neighbourhoodnanny.babysitter;

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
    public Babysitter add(@RequestBody Babysitter babysitter) {
        return babysitterRepository.save(babysitter);
    }

    @GetMapping("/{id}")
    public Babysitter getById(@PathVariable long id) {
        return babysitterRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        babysitterRepository.deleteById(id);
    }

    @DeleteMapping("/{id}/child/{childId}")
    public void deleteAccount(@PathVariable long id, @PathVariable long childId) {
        Optional<Babysitter> babysitter = babysitterRepository.findById(id);
        Optional<Child> child = childRepository.findById(childId);
        if (babysitter.isPresent() && child.isPresent()) {
            babysitter.get().removeChild(child.get());
            babysitterRepository.save(babysitter.get());
        }
    }
}
