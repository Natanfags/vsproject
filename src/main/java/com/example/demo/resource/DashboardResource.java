package com.example.demo.resource;

import com.example.demo.entity.dto.DashboardStatusServicosDTO;
import com.example.demo.entity.dto.EstadoIndisponibilidadeDTO;
import com.example.demo.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@AllArgsConstructor
public class DashboardResource {

    private final DashboardService dashboardService;

    @GetMapping("/get-status-indisponibilidade-maior")
    public ResponseEntity<EstadoIndisponibilidadeDTO> getSatusComMariorIndisponibilidade() {
        return ResponseEntity.ok(dashboardService.getEstadosComMariorIndisponibilidade());
    }

    @GetMapping("/get-status-servicos")
    public ResponseEntity<List<DashboardStatusServicosDTO>> getSatusServicos() {
        return ResponseEntity.ok(dashboardService.getDadosStatusServicoDashboard());
    }
}
