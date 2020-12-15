package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/babysitter")
public class BabysitterController {
    BabysitterRepository babysitterRepository;

    public BabysitterController(BabysitterRepository babysitterRepository) {
        this.babysitterRepository = babysitterRepository;
    }

    @GetMapping
    public List<Babysitter> getAll() {
        return babysitterRepository.findAll();
    }

    @PostMapping
    public Babysitter add(@RequestBody Babysitter babysitter){
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
}
