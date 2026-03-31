package com.relatech.backend.service;

import com.relatech.backend.model.Mask;
import com.relatech.backend.model.User;
import com.relatech.backend.repository.MaskRepository;
import com.relatech.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaskService {

    private final MaskRepository maskRepository;
    private final UserRepository userRepository;

    public MaskService(MaskRepository maskRepository, UserRepository userRepository) {
        this.maskRepository = maskRepository;
        this.userRepository = userRepository;
    }

    // Busca o usuário pelo email (vem do token JWT)
    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // Retorna só as máscaras do usuário autenticado
    public List<Mask> findAll(String email) {
        return maskRepository.findByUser(getUser(email));
    }

    // Busca uma máscara — só retorna se for do usuário autenticado
    public Optional<Mask> findById(Long id, String email) {
        return maskRepository.findByIdAndUser(id, getUser(email));
    }

    // Cria uma máscara vinculada ao usuário
    public Mask save(Mask mask, String email) {
        mask.setUser(getUser(email));
        return maskRepository.save(mask);
    }

    // Atualiza — só permite se a máscara for do usuário
    public Optional<Mask> update(Long id, Mask updated, String email) {
        return findById(id, email).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmoji(updated.getEmoji());
            existing.setColor(updated.getColor());
            existing.setTemplate(updated.getTemplate());
            existing.setFields(updated.getFields());
            return maskRepository.save(existing);
        });
    }

    // Deleta — só permite se a máscara for do usuário
    public boolean delete(Long id, String email) {
        return findById(id, email).map(mask -> {
            maskRepository.delete(mask);
            return true;
        }).orElse(false);
    }
}