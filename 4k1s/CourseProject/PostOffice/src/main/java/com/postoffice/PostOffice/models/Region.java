package com.postoffice.PostOffice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "index")
    private int index;

    @ManyToOne
    @JoinColumn(name="post_office_id", nullable=false)
    private PostOffice postOffice;

    @OneToMany(mappedBy="region")
    private Set<House> houses;

    @OneToMany(mappedBy="region")
    private Set<Employee> employees;
}
