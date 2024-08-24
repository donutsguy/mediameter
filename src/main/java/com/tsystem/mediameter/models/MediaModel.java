package com.tsystem.mediameter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="media")
public class MediaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate release_date;
    private String photo;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable=false)
    private PlatformModel platform;

    @ManyToOne
    @JoinColumn(name="idiom_id", nullable=false)
    private IdiomModel idiom;

    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    private CountryModel country;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private GenreModel genre;

    @ManyToOne
    @JoinColumn(name="team_id", nullable=false)
    private TeamModel team;

    @ManyToOne
    @JoinColumn(name="media_type_id", nullable=false)
    private MediaTypeModel media_type;

    @ManyToOne
    @JoinColumn(name="user_media_id", nullable=false)
    private UserMediaModel user_media;

    @JsonIgnore
    @OneToMany(mappedBy = "media")
    private List<RatingUserModel> ratings;



}
