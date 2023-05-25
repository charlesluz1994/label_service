package com.cluz.coscus.label.services;

import com.cluz.coscus.label.entities.Label;
import com.cluz.coscus.label.exceptions.LabelResourceException;
import com.cluz.coscus.label.exceptions.LabelResourceNotFoundException;
import com.cluz.coscus.label.repositories.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository labelRepository;

    public Label createLabel(Label label) {
        Optional<Label> existingLabel = labelRepository.findByCode(label.getCode());
        if (existingLabel.isPresent()) {
            throw new LabelResourceException("Label already exists " + label.getCode());
        }
        return labelRepository.save(label);
    }

    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public Optional<Label> getLabelByCode(String code) {
        Optional<Label> expectedLabel = labelRepository.findByCode(code);
        if (expectedLabel.isEmpty()) {
            throw new LabelResourceNotFoundException("Label not found with this code " + expectedLabel.get().getCode());
        }

        return expectedLabel;
    }

    public void deleteLabel(String code) {
        Label label = labelRepository.findByCode(code)
                .orElseThrow(() -> new LabelResourceNotFoundException("Label not found with code: " + code));

        labelRepository.delete(label);
    }

    public Label updateLabel(String code, Label updatedLabel) {
        Label label = labelRepository.findByCode(code)
                .orElseThrow(() -> new LabelResourceNotFoundException("Label not found with code: " + code));
        label.setCode(updatedLabel.getCode());
        label.setDescription(updatedLabel.getDescription());
        return labelRepository.save(label);
    }
}