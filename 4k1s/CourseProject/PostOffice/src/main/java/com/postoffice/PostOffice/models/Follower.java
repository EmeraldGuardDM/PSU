package com.postoffice.PostOffice.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Follower {
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "follower_subscription",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private Set<Subscription> subscriptions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="house_id", nullable=false)
    private House house;
}
