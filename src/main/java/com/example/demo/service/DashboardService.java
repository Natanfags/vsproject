package com.example.demo.service;

import com.example.demo.entity.dto.DashboardStatusServicosDTO;
import com.example.demo.entity.dto.EstadoIndisponibilidadeDTO;
import com.example.demo.repository.StatusServicosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DashboardService {

    private final StatusServicosRepository statusServicosRepository;

    public EstadoIndisponibilidadeDTO getEstadosComMariorIndisponibilidade() {
        return statusServicosRepository.findStatusComIndisponibildadeMaior();
    }

    public List<DashboardStatusServicosDTO> getDadosStatusServicoDashboard() {
        return statusServicosRepository.getAllStatusServicos();
    }
}
