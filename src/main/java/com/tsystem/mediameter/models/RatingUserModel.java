package com.tsystem.mediameter.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rating_user")
public class RatingUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_media_id")
    private UserMediaModel userMedia;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private RatingModel rating;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private MediaModel media;
}
