package com.example.demo.service;

import com.example.demo.converter.StatusServicoNFEConverter;
import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.entity.dto.CountStatusDTO;
import com.example.demo.entity.dto.DashboardStatusServicosDTO;
import com.example.demo.entity.dto.EstadoIndisponibilidadeDTO;
import com.example.demo.repository.StatusServicosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class DashboardService {

    private final StatusServicosRepository statusServicosRepository;
    private final StatusServicoNFEConverter converter;

    public EstadoIndisponibilidadeDTO getEstadosComMariorIndisponibilidade() {
        return statusServicosRepository.findStatusComIndisponibildadeMaior();
    }

    public List<DashboardStatusServicosDTO> getDadosStatusServicoDashboard() {
        return statusServicosRepository.getAllStatusServicos();
    }

    private List<StatusServicosNFE> getStatusServicosNFES() {
        Iterable<StatusServicosNFE> all = statusServicosRepository.findAll();

        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
    }

    public CountStatusDTO getAllStatusCounted() {
        List<StatusServicosNFE> statusServicosNFES = getStatusServicosNFES();
        return converter.getCountAllStatus(statusServicosNFES);
    }
    //TODO Tests
}
