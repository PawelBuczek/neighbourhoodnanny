package pl.sdacademy.neighbourhoodnanny.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        locationRepository.deleteById(id);
    }
}
