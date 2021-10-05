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

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    private Region region;

    @OneToMany(mappedBy="house")
    private Set<Follower> followers;
}
