package com.cluz.coscus.label.services;
/*
import com.cluz.coscus.label.entities.Label;
import com.cluz.coscus.label.exceptions.LabelResourceNotFoundException;
import com.cluz.coscus.label.repositories.LabelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class LabelServiceTest {

    @InjectMocks
    private LabelService labelService;

    @Mock
    LabelRepository labelRepository;

    @Captor
    ArgumentCaptor<Label> labelCaptor;

    @Test
    @DisplayName("create label with success")
    void givenLabelCreateLabelWithSuccess() {
        //Given
        var label = getLabel();

        // When
        labelService.createLabel(label);

        // Then
        Mockito.verify(labelRepository).save(labelCaptor.capture());
        Label labelSalved = labelCaptor.getValue();

        Assertions.assertThat(labelSalved.getCode()).isNotNull();
        Assertions.assertThat(labelSalved.getDescription()).isNotNull();

    }

    @Test
    @DisplayName("When Label is not found, throw exception Label not found")
    void givenLabelThrowExceptionLabelNotFound() {
        //Given
        var label = getLabel();

        // When
        Mockito.when(labelService.getLabelById(any())).thenReturn(Optional.empty());

        // Then
        LabelResourceNotFoundException labelResourceNotFoundException = assertThrows(LabelResourceNotFoundException.class, () ->{
            labelService.createLabel(label);
        });

        Assertions.assertThat(labelResourceNotFoundException.getMessage()).isEqualTo("Label not found with id " + label.getId());
    }

    @Test
    void getAllLabels() {
    }

    @Test
    void getLabelById() {
    }

    @Test
    void getLabelByCode() {
    }

    @Test
    void deleteLabel() {
    }

    @Test
    void updateLabel() {
    }

    private Label getLabel() {
        Label label = new Label();
        label.setId(1L);
        label.setCode("001");
        label.setDescription("Descrição da etiqueta 001");
        return label;
    }
}*/
