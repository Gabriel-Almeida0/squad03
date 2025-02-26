package squad03.core.ports;

import squad03.adapter.dtos.AmostraRequestDto;

public interface AmostraServicePort {
    String criarProtocolo(AmostraRequestDto amostraRequestDto);
}
