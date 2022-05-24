package com.udemy.person.controller;

import com.udemy.person.data.vo.PersonVO;
import com.udemy.person.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@Tag(name = "Person", description = "End Points to Person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Create a person")
    @PostMapping
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
    }

    @Operation(summary = "Find one by id")
    @GetMapping("/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @Operation(summary = "List all people")
    @GetMapping
    public ResponseEntity<List<PersonVO>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @Operation(summary = "Update a person")
    @PutMapping("/{id}")
    public ResponseEntity<PersonVO> update(@PathVariable Long id, @RequestBody PersonVO person) {
        return ResponseEntity.ok(personService.update(id, person));
    }

    @Operation(summary = "Delete one person")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
