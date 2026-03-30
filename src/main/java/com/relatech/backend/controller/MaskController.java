package com.relatech.backend.controller;
import java.util.Optional;
import com.relatech.backend.model.Mask;
import com.relatech.backend.service.MaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masks")
@CrossOrigin(origins = "*")
public class MaskController {

    private final MaskService maskService;

    public MaskController(MaskService maskService) {
        this.maskService = maskService;
    }

    @GetMapping
    public List<Mask> getAll() {
        return maskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mask> getById(@PathVariable Long id) {
        return maskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mask> create(@RequestBody Mask mask) {
        Mask created = maskService.save(mask);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mask> update(@PathVariable Long id, @RequestBody Mask mask) {
        return maskService.update(id, mask)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mask> delete(@PathVariable Long id) {
        if (maskService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
