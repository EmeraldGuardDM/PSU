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

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String email;
    private String phone;
    private int position_id;
    private int post_office_id;
}
