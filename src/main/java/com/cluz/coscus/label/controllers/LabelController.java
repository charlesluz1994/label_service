package com.cluz.coscus.label.controllers;

import com.cluz.coscus.label.entities.Label;
import com.cluz.coscus.label.exceptions.LabelResourceNotFoundException;
import com.cluz.coscus.label.services.LabelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labels")
public class LabelController {

    private static Logger logger = LoggerFactory.getLogger(LabelController.class);
    private final LabelService labelService;
    @Autowired
    private Environment environment;

    @PostMapping
    public ResponseEntity<Label> createLabel(@RequestBody @Valid Label label) {

        return ResponseEntity.status(HttpStatus.CREATED).body(labelService.createLabel(label));
    }

    @GetMapping("/{code}")
    // @Cacheable(value = "LabelByCodeCache", key = "#code")
    public ResponseEntity<Label> getLabelByCode(@PathVariable String code) {
        Optional<Label> optLabel = labelService.getLabelByCode(code);

        if (optLabel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(optLabel.get());
    }

    @GetMapping
    public ResponseEntity<List<Label>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(labelService.getAllLabels());
    }

    @PutMapping("/{code}")
    public ResponseEntity<Label> updateLabel(@PathVariable String code, @RequestBody @Valid Label label) {
        return ResponseEntity.status(HttpStatus.OK).body(labelService.updateLabel(code, label));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteLabel(@PathVariable String code) {
        labelService.deleteLabel(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}