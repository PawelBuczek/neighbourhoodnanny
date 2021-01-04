package pl.sdacademy.neighbourhoodnanny.child;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/child")
public class ChildController {
    ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @GetMapping
    public List<Child> getAll() {
        return childRepository.findAll();
    }

    @PostMapping
    public Child add(@RequestBody Child child) {
        return childRepository.save(child);
    }

    @GetMapping("/{id}")
    public Child getById(@PathVariable long id) {
        return childRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        childRepository.deleteById(id);
    }
}
