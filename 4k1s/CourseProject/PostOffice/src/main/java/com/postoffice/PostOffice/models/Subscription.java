package com.postoffice.PostOffice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "description")
    private String description;
    @Column(name = "term")
    private int term;
    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne
    @JoinColumn(name="release_id", nullable=false)
    private Release release;

    @ManyToMany(mappedBy = "subscriptions")
    private Set<Follower> followers;
}
