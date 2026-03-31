package com.relatech.backend.repository;

import com.relatech.backend.model.Mask;
import com.relatech.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaskRepository extends JpaRepository<Mask, Long> {
    // Busca todas as máscaras de um usuário
    List<Mask> findByUser(User user);
    // Busca uma máscara pelo id e usuário — evita que um usuário veja máscara de outro
    Optional<Mask> findByIdAndUser(Long id, User user);
}