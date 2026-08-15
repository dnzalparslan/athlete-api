package com.md.athlete_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    private final List<Athlete> athletes = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Athlete> getAllAthletes() {
        return athletes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Athlete> getAthleteById(@PathVariable Long id) {

        Optional<Athlete> athlete = athletes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();

        return athlete
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete) {

        athlete.setId(nextId++);
        athletes.add(athlete);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(athlete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Athlete> updateAthlete(
            @PathVariable Long id,
            @RequestBody Athlete updatedAthlete) {

        for (Athlete athlete : athletes) {

            if (athlete.getId().equals(id)) {
                athlete.setName(updatedAthlete.getName());
                athlete.setPosition(updatedAthlete.getPosition());

                return ResponseEntity.ok(athlete);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id) {

        boolean removed = athletes.removeIf(athlete -> athlete.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
