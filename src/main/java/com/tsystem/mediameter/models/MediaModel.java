package com.tsystem.mediameter.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="media")
public class MediaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate releaseDate;

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
    private MediaTypeModel mediaType;

    @ManyToOne
    @JoinColumn(name="user_media_id", nullable=false)
    private UserMediaModel userMedia;

    @JsonIgnore
    @OneToMany(mappedBy = "media")
    private List<RatingUserModel> ratings;



}
