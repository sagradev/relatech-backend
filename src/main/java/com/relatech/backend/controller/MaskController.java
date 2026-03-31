package com.relatech.backend.controller;

import com.relatech.backend.model.Mask;
import com.relatech.backend.service.MaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masks")
public class MaskController {

    private final MaskService maskService;

    public MaskController(MaskService maskService) {
        this.maskService = maskService;
    }

    // O @AuthenticationPrincipal pega o email do token JWT automaticamente
    @GetMapping
    public List<Mask> getAll(@AuthenticationPrincipal String email) {
        return maskService.findAll(email);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mask> getById(@PathVariable Long id,
                                        @AuthenticationPrincipal String email) {
        return maskService.findById(id, email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mask> create(@RequestBody Mask mask,
                                       @AuthenticationPrincipal String email) {
        Mask created = maskService.save(mask, email);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mask> update(@PathVariable Long id,
                                       @RequestBody Mask mask,
                                       @AuthenticationPrincipal String email) {
        return maskService.update(id, mask, email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
                                       @AuthenticationPrincipal String email) {
        if (maskService.delete(id, email)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}