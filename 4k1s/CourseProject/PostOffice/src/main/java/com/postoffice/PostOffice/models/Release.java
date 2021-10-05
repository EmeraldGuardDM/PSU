package com.postoffice.PostOffice.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private int count;
    private int publication_id;
    private int post_office_id;
}
