package pl.sdacademy.neighbourhoodnanny.ChildCareEvent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ChildCareEvent getById(@PathVariable long id) {
        return childCareEventRepository.findById(id).orElse(null);
    }
}
