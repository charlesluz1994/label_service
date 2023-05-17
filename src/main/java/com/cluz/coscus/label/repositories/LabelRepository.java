package com.cluz.coscus.label.repositories;

import com.cluz.coscus.label.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByCode(String code);
}
