package com.tsystem.mediameter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany(mappedBy = "user_media")
    private List<RatingUserModel> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "user_media", fetch = FetchType.LAZY)
    private List<MediaModel> medias;
}
