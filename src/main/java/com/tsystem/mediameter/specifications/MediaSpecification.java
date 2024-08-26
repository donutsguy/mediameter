package com.tsystem.mediameter.specifications;

import com.tsystem.mediameter.models.MediaModel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class MediaSpecification {
    public static Specification<MediaModel> containsName(String name) {
        return ((root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"));
    }

    public static Specification<MediaModel> containsDescription(String description) {
        return ((root, query, criteriaBuilder) ->
                description == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(criteriaBuilder.lower(root.get("description")),
                    "%" + description.toLowerCase() + "%"));
    }

    public static Specification<MediaModel> hasPlatform(String platform) {
        return ((root, query, criteriaBuilder) ->
                platform == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("platform").get("name"), platform));
    }

    public static Specification<MediaModel> hasIdiom(String idiom) {
        return ((root, query, criteriaBuilder) ->
                idiom == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idiom").get("name"), idiom));
    }

    public static Specification<MediaModel> hasCountry(String country) {
        return ((root, query, criteriaBuilder) ->
                country == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("country").get("name"), country));
    }

    public static Specification<MediaModel> hasGenre(String genre) {
        return ((root, query, criteriaBuilder) ->
                genre == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("genre").get("name"), genre));
    }

    public static Specification<MediaModel> hasTeam(String team) {
        return ((root, query, criteriaBuilder) ->
                team == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("team").get("name"), team));
    }

    public static Specification<MediaModel> hasMediaType(String mediaType) {
        return ((root, query, criteriaBuilder) ->
                mediaType == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("mediaType").get("name"), mediaType));
    }

    public static Specification<MediaModel> hasUserMedia(String userMedia) {
        return ((root, query, criteriaBuilder) ->
                userMedia == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("userMedia").get("name"), userMedia));
    }

    public static Specification<MediaModel> hasReleaseDateRange(LocalDate startDate, LocalDate endDate) {
        return ((root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null) return criteriaBuilder.between(root.get("releaseDate"), startDate, endDate);
            else if (startDate != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("releaseDate"), startDate);
            else if (endDate != null) return criteriaBuilder.lessThanOrEqualTo(root.get("releaseDate"), endDate);
            else return criteriaBuilder.conjunction();
        });
    }
}
