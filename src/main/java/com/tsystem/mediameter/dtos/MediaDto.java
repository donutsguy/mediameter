package com.tsystem.mediameter.dtos;

import com.tsystem.mediameter.models.*;

import java.time.LocalDate;

public record MediaDto(Long id,
         String name,
         String description,
         LocalDate release_date,
         String photo,
         PlatformModel platform,
         IdiomModel idiom,
         CountryModel country,
         GenreModel genre,
         TeamModel team,
         MediaTypeModel media_type,
         UserMediaModel user_media
) {}
