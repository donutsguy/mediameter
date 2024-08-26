package com.tsystem.mediameter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_media")
public class UserMediaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "userMedia")
    private List<RatingUserModel> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "userMedia", fetch = FetchType.LAZY)
    private List<MediaModel> medias;
}
