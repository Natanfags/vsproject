package com.example.demo.resource;

import com.example.demo.entity.dto.StatusServicosDTO;
import com.example.demo.service.StatusServicosService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/status-servicos")
@AllArgsConstructor
public class ExtractDataResource {

    private final StatusServicosService statusServicosService;

    @GetMapping("/get-all-estados")
    public ResponseEntity<List<String>> findAllStadosDisponiveis() {
        return ResponseEntity.ok(statusServicosService.findAllEstadosDisponiveis());
    }

    @GetMapping("/get-status-atual-servicos")
    public ResponseEntity<List<StatusServicosDTO>> getStatusAtual() {
        return ResponseEntity.ok(statusServicosService.findStatusAtualServicos());
    }

    @GetMapping("/get-status-by-estado")
    public ResponseEntity<List<StatusServicosDTO>> getStatusServiceosByEstado(@RequestParam("estado") String estado) {
        return ResponseEntity.ok(statusServicosService.findStatusServicoByEstados(estado));
    }

    @GetMapping("/get-status-by-data")
    public ResponseEntity<List<StatusServicosDTO>> getStatusServicoByData(@RequestParam("data")
                                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {

        return ResponseEntity.ok(statusServicosService.findStatusByData(data));
    }

}
