package squad03.core.services;

import org.springframework.stereotype.Service;
import squad03.core.ports.AmostraServicePort;
import squad03.core.ports.AmostraRepositoryPort;
import squad03.core.ports.MunicipioRepositoryPort;
import squad03.adapter.dtos.AmostraRequestDto;
import squad03.adapter.entities.AmostraEntity;
import squad03.adapter.entities.MunicipioEntity;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AmostraService implements AmostraServicePort {

    private final AtomicInteger protocoloCounter = new AtomicInteger(1);
    private final AmostraRepositoryPort amostraRepositoryPort;
    private final MunicipioRepositoryPort municipioRepositoryPort;

    public AmostraService(AmostraRepositoryPort amostraRepositoryPort, MunicipioRepositoryPort municipioRepositoryPort) {
        this.amostraRepositoryPort = amostraRepositoryPort;
        this.municipioRepositoryPort = municipioRepositoryPort;
    }
    @Override
    public String criarProtocolo(AmostraRequestDto amostraRequestDto) {
        validarAmostra(amostraRequestDto);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String data = dateFormat.format(new Date());
        int numeroProtocolo = protocoloCounter.getAndIncrement();
        String protocolo = data + "-" + String.format("%05d", numeroProtocolo);

        Date dataCaptura = Date.from(amostraRequestDto.getDataCaptura().atStartOfDay(ZoneId.systemDefault()).toInstant());

        MunicipioEntity municipioEntity = municipioRepositoryPort.findByNome(amostraRequestDto.getMunicipio());
        if (municipioEntity == null) {
            throw new IllegalArgumentException("Município não encontrado.");
        }

        AmostraEntity amostraEntity = new AmostraEntity(
                null,
                municipioEntity,
                amostraRequestDto.getQuantidadeAmostras(),
                amostraRequestDto.getTipoAmostra(),
                amostraRequestDto.getEnderecoCaptura(),
                dataCaptura,
                amostraRequestDto.getIdentificacaoInseto(),
                protocolo
        );

        amostraRepositoryPort.save(amostraEntity);
        return protocolo;
    }

    private void validarAmostra(AmostraRequestDto amostraRequestDto) {
        if (amostraRequestDto.getMunicipio() == null || amostraRequestDto.getMunicipio().trim().isEmpty()) {
            throw new IllegalArgumentException("Município não pode ser nulo ou vazio.");
        }
        if (amostraRequestDto.getQuantidadeAmostras() <= 0) {
            throw new IllegalArgumentException("Quantidade de amostras deve ser maior que zero.");
        }
        if (amostraRequestDto.getTipoAmostra() == null || amostraRequestDto.getTipoAmostra().trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de amostra não pode ser nulo ou vazio.");
        }
        if (amostraRequestDto.getEnderecoCaptura() == null || amostraRequestDto.getEnderecoCaptura().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço de captura não pode ser nulo ou vazio.");
        }
        if (amostraRequestDto.getDataCaptura() == null) {
            throw new IllegalArgumentException("Data de captura não pode ser nula.");
        }
        if (amostraRequestDto.getDataCaptura().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Data de captura não pode ser no futuro.");
        }
        if (amostraRequestDto.getIdentificacaoInseto() == null || amostraRequestDto.getIdentificacaoInseto().trim().isEmpty()) {
            throw new IllegalArgumentException("Identificação do inseto não pode ser nula ou vazia.");
        }
    }
}
