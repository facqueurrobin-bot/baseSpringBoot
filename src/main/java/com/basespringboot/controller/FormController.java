package com.basespringboot.controller;

import com.basespringboot.dto.FormDto;
import com.basespringboot.entity.Form;
import com.basespringboot.service.FormService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    // CREATE (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Form save(@Valid @RequestBody FormDto form) {
        return formService.save(form);
    }

    // READ ALL (GET)
    @GetMapping
    public List<Form> findAll() {
        return formService.findAll();
    }

    // READ BY ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Form> findById(@PathVariable Long id) {
        return formService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Form> update(@PathVariable Long id, @Valid @RequestBody FormDto form) {
        return formService.update(id, form)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (formService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}