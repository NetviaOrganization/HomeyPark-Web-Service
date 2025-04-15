package Netvia.SwapServiceAPI.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(String userId) {
    public UserId(){
        this(null);
    }
    public UserId{
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User Id cannot be null or blank");
        }
    }
}
