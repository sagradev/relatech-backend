package com.relatech.backend.service;

import com.relatech.backend.model.Mask;
import com.relatech.backend.repository.MaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaskService {

    private final MaskRepository maskRepository;

    public MaskService(MaskRepository maskRepository) {
        this.maskRepository = maskRepository;
    }

    public List<Mask> findAll() {
        return maskRepository.findAll();
    }

    public Optional<Mask> findById(Long id) {
        return maskRepository.findById(id);
    }

    public Mask save(Mask mask) {
        return maskRepository.save(mask);
    }

    public Optional<Mask> update(Long id, Mask updated) {
        return maskRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmoji(updated.getEmoji());
            existing.setColor(updated.getColor());
            existing.setTemplate(updated.getTemplate());
            existing.setFields(updated.getFields());
            return maskRepository.save(existing);
        });
    }

    public Boolean delete(Long id){
        if(maskRepository.existsById(id)){
            maskRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
