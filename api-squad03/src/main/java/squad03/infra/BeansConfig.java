package squad03.infra;

import squad03.core.ports.UsuarioRepositoryPort;
import squad03.core.ports.UsuarioServicePort;
import squad03.core.ports.TokenServicePort;
import squad03.core.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import squad03.adapter.security.JwtTokenServiceAdapter;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UsuarioServicePort usuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort, TokenServicePort tokenServicePort) {
        return new UsuarioService(usuarioRepositoryPort, tokenServicePort);
    }

    @Bean
    public TokenServicePort tokenServicePort() {
        return new JwtTokenServiceAdapter();
    }
}
