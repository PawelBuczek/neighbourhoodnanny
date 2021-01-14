package pl.sdacademy.neighbourhoodnanny.childcareevent;

import org.springframework.web.bind.annotation.*;
import pl.sdacademy.neighbourhoodnanny.location.Location;
import pl.sdacademy.neighbourhoodnanny.location.LocationRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/event")
public class ChildCareEventController {
    ChildCareEventRepository childCareEventRepository;
    LocationRepository locationRepository;

    public ChildCareEventController(ChildCareEventRepository childCareEventRepository, LocationRepository locationRepository) {
        this.childCareEventRepository = childCareEventRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<ChildCareEvent> getAll() {
        return childCareEventRepository.findAll();
    }

    @PostMapping
    public ChildCareEvent add(@RequestBody ChildCareEvent childCareEvent) {
        return childCareEventRepository.save(childCareEvent);
    }

    @PostMapping("/dto")
    public void addEventWithLocation(@RequestBody ChildCareEventLocationDTO DTO) {
        Location location = new Location(DTO.getStreet(), DTO.getPostalCode(), DTO.getCity());
        ChildCareEvent childCareEvent = new ChildCareEvent(DTO.getName(), DTO.getStartTime(), DTO.getEndTime(), DTO.getChildren(), location);
        locationRepository.save(location);
        childCareEventRepository.save(childCareEvent);
    }

    @GetMapping("/{id}")
    public ChildCareEvent getById(@PathVariable long id) {
        return childCareEventRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        childCareEventRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ChildCareEvent childCareEvent, @PathVariable long id) {
        Optional<ChildCareEvent> childCareEventOptional = childCareEventRepository.findById(id);
        if (!childCareEventOptional.isPresent()) {
            System.out.println("Event with id: " + id + " not found");
        }
        childCareEvent.setId(id);
        childCareEventRepository.save(childCareEvent);
    }
}
