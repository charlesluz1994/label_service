package com.cluz.coscus.label.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "label")
public class Label implements Serializable {


    @Id
    @Column(name = "code", nullable = false)
    String code;

    @Column(name = "description", nullable = false)
    @NotNull
    String description;
}