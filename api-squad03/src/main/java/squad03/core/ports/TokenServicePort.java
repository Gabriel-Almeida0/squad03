package squad03.core.ports;

public interface TokenServicePort {
    String generateToken(String username);

    boolean isValidToken(String token);
}
