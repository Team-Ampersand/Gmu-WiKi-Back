package mpersand.Gmuwiki.domain.auth.repository;

import mpersand.Gmuwiki.domain.auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    RefreshToken findByToken(String token);

    RefreshToken findByUserId(UUID userId);
}
