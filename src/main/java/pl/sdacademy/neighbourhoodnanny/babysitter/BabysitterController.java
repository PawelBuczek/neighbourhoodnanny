package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public Babysitter getById(@PathVariable long id) {
        return babysitterRepository.findById(id).orElse(null);
    }
}
