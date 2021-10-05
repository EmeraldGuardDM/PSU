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
@Table(name = "post_office")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy="postOffice")
    private Set<Employee> employees;

    @OneToMany(mappedBy="postOffice")
    private Set<Release> releases;

    @OneToMany(mappedBy="postOffice")
    private Set<Region> regions;
}
