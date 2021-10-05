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

public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "price")
    private int price;
    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name="publication_id", nullable=false)
    private Publication publication;

    @ManyToOne
    @JoinColumn(name="post_office_id", nullable=false)
    private PostOffice postOffice;

    @OneToMany(mappedBy="release")
    private Set<Subscription> subscriptions;
}
