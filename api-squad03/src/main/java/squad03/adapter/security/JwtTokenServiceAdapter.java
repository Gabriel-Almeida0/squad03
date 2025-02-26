package squad03.adapter.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import squad03.core.ports.TokenServicePort;
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
        long expirationTime = 1000L * 60 * 60;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    @Override
    public boolean isValidToken(String token) {
        try {

            String tokenValue = token.startsWith("Bearer ") ? token.substring(7) : token;

            Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .parseClaimsJws(tokenValue);

            return true;
        } catch (JwtException e) {

            return false;
        }
    }
}
