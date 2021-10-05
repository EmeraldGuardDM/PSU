package com.postoffice.PostOffice.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name="position_id", nullable=false)
    private Position position;

    @ManyToOne
    @JoinColumn(name="post_office_id", nullable=false)
    private PostOffice postOffice;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    private Region region;
}
