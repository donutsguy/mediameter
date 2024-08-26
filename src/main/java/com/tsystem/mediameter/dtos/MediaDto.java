package com.tsystem.mediameter.dtos;

import com.tsystem.mediameter.models.*;

import java.time.LocalDate;

public record MediaDto(
         String name,
         String description,
         LocalDate releaseDate,
         String photo,
         PlatformModel platform,
         IdiomModel idiom,
         CountryModel country,
         GenreModel genre,
         TeamModel team,
         MediaTypeModel mediaType,
         UserMediaModel userMedia
) {
    public static MediaDto from(MediaModel media){
        return new MediaDto(media.getName(), media.getDescription(), media.getReleaseDate(), media.getPhoto(),
                media.getPlatform(), media.getIdiom(), media.getCountry(), media.getGenre(), media.getTeam(),
                media.getMediaType(), media.getUserMedia());
    }
}
