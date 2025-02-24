package squad03.adapter.security;

import org.springframework.stereotype.Component;
import squad03.core.ports.TokenServicePort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenServiceAdapter implements TokenServicePort {

    private static final String SECRET_KEY = "u8DoZh5twYQeYw40H4rpsPzUyC1ORQ4quosI0JIdqqg=";

    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    @Override
    public String generateToken(String username) {
        SecretKey key = getSigningKey();
        long expirationTime = 1000 * 60 * 60;  // 1 hora de expiração
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }
}
