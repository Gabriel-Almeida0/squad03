package squad03.core.services;

import squad03.core.domain.Usuario;
import squad03.core.ports.UsuarioRepositoryPort;
import squad03.core.ports.UsuarioServicePort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;


public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    private static final String SECRET_KEY = "u8DoZh5twYQeYw40H4rpsPzUyC1ORQ4quosI0JIdqqg=";


    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public String login(String nome, String senha) {
        Usuario usuario = usuarioRepositoryPort.obtainByNome(nome);
        if (usuario == null || !usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Credenciais inválidas!");
        }

        return generateJwt(usuario);
    }

    private String generateJwt(Usuario usuario) {
        SecretKey key = getSigningKey();

        long expirationTime = 1000 * 60 * 60;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(usuario.getNome())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }
}
