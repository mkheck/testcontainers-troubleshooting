package com.thehecklers.copilottest1;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftRepository repo;
    
    public AircraftController(AircraftRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Aircraft> getAllAircraft() {
        return repo.findAll();
    }

    @GetMapping("/{adshex}")
    public Optional<Aircraft> getAircraftByAdshex(String adshex) {
        return repo.findById(adshex);
    }

    @PostMapping()
    public Aircraft addAircraft(@RequestBody Aircraft newAircraft) {
        return repo.save(newAircraft);
    }
}
