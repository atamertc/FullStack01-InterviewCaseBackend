package com.atamertc.repository.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String province;
    @ElementCollection
    private Set<String> districts;
    private int population;

}