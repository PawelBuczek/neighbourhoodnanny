package pl.sdacademy.neighbourhoodnanny.ChildCareEvent;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class ChildCareEventController {
    ChildCareEventRepository childCareEventRepository;

    public ChildCareEventController(ChildCareEventRepository childCareEventRepository) {
        this.childCareEventRepository = childCareEventRepository;
    }

    @GetMapping
    public List<ChildCareEvent> getAll() {
        return childCareEventRepository.findAll();
    }

    @PostMapping
    public ChildCareEvent add(@RequestBody ChildCareEvent childCareEvent) {
        return childCareEventRepository.save(childCareEvent);
    }

    @GetMapping("/{id}")
    public ChildCareEvent getById(@PathVariable long id) {
        return childCareEventRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        childCareEventRepository.deleteById(id);
    }
}
