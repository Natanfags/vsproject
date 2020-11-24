package com.example.demo.converter;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.dto.StatusServicosDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class StatusServicoNFEConverter {

    public StatusServicosDTO converteEntidadeToDto(StatusServicosNFE entidade) {
        StatusServicosDTO statusServicosDTO = new StatusServicosDTO();

        statusServicosDTO.setStatus(entidade.getStatus());
        statusServicosDTO.setAutorizador(entidade.getAutorizador());
        statusServicosDTO.setData(entidade.getData());

        return statusServicosDTO;
    }

    public StatusServicosNFE converteDtoFromEntidade(StatusServicosDTO dto) {
        StatusServicosNFE statusServicosNFE = new StatusServicosNFE();

        statusServicosNFE.setStatus(dto.getStatus());
        statusServicosNFE.setAutorizador(dto.getAutorizador());
        statusServicosNFE.setData(dto.getData());

        return statusServicosNFE;
    }

    public List<StatusServicosDTO> converteListaToDto(List<StatusServicosNFE> entidadeList) {

        List<StatusServicosDTO> dtoList = new ArrayList<>();
        entidadeList.forEach(e -> {
            dtoList.add(converteEntidadeToDto(e));
        });

        return dtoList;
    }

    public List<StatusServicosNFE> converteListaToEntidade(List<StatusServicosDTO> dtoList) {
        List<StatusServicosNFE> entidadeList = new ArrayList<>();

        dtoList.forEach(d -> {
            entidadeList.add(converteDtoFromEntidade(d));
        });

        return entidadeList;
    }
}
