package squad03.infra;

import squad03.core.ports.UsuarioRepositoryPort;
import squad03.core.ports.UsuarioServicePort;
import squad03.core.ports.TokenServicePort;
import squad03.core.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import squad03.adapter.security.JwtTokenServiceAdapter;
import squad03.core.services.AmostraService;
import squad03.core.ports.AmostraServicePort;
import squad03.adapter.repositories.AmostraRepository;
import squad03.core.ports.AmostraRepositoryPort;
import squad03.adapter.repositories.AmostraRepositoryAdapter;
import squad03.core.ports.MunicipioRepositoryPort;
import squad03.adapter.repositories.MunicipioRepositoryAdapter;

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

    @Bean
    public AmostraServicePort amostraServicePort(AmostraRepositoryPort amostraRepositoryPort, MunicipioRepositoryPort municipioRepositoryPort) {
        return new AmostraService(amostraRepositoryPort, municipioRepositoryPort);
    }

    @Bean
    public AmostraRepositoryPort amostraRepositoryPort(AmostraRepository amostraRepository) {
        return new AmostraRepositoryAdapter(amostraRepository);
    }

    @Bean
    public MunicipioRepositoryPort municipioRepositoryPort(MunicipioRepositoryAdapter municipioRepositoryAdapter) {
        return municipioRepositoryAdapter;
    }
}
