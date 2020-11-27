package com.example.demo.converter;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.dto.CountStatusDTO;
import com.example.demo.entity.dto.StatusServicosDTO;
import com.example.demo.entity.enums.Status;
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

    public List<StatusServicosDTO> converteListaToDto(List<StatusServicosNFE> entidadeList) {

        List<StatusServicosDTO> dtoList = new ArrayList<>();
        entidadeList.forEach(e -> {
            dtoList.add(converteEntidadeToDto(e));
        });

        return dtoList;
    }

    public CountStatusDTO getCountAllStatus(List<StatusServicosNFE> statusServicosNFES) {

        List<Integer> countVerde = new ArrayList<>();
        List<Integer> countAmarelo = new ArrayList<>();
        List<Integer> countVermelho = new ArrayList<>();

        for (StatusServicosNFE statusServicosNFE : statusServicosNFES) {
            if (statusServicosNFE.getStatus().equals(Status.VERDE)) {
                countVerde.add(1);
            } else if (statusServicosNFE.getStatus().equals(Status.AMARELA)) {
                countAmarelo.add(1);
            } else {
                countVermelho.add(1);
            }
        }

        Integer verde = countVerde.stream().mapToInt(Integer::intValue).sum();
        Integer amarelo = countAmarelo.stream().mapToInt(Integer::intValue).sum();
        Integer vermelho = countVermelho.stream().mapToInt(Integer::intValue).sum();

        CountStatusDTO countStatusDTO = new CountStatusDTO();
        countStatusDTO.setStatusVerde(verde);
        countStatusDTO.setGetStatusAmarelo(amarelo);
        countStatusDTO.setStatusVermelho(vermelho);

        return countStatusDTO;
    }
}
