package pl.sdacademy.neighbourhoodnanny.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
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
    @PostMapping
    public Location add(@RequestBody Location location){
        return locationRepository.save(location);
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
