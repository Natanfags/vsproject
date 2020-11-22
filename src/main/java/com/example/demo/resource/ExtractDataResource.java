package com.example.demo.resource;

import com.example.demo.entity.StatusServicosNFE;
import com.example.demo.service.StatusServicosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/status-servicos")
@AllArgsConstructor
public class ExtractDataResource {


    private final StatusServicosService statusServicosService;

    @GetMapping("/get-status-atual-servicos")
    public ResponseEntity<List<StatusServicosNFE>> getStatusAtual() {
        return ResponseEntity.ok(statusServicosService.findStatusAtualServicos());
    }

    @GetMapping("/get-status-by-estados")
    public ResponseEntity<List<StatusServicosNFE>> getStatusServiceosByEstado(@RequestParam("estado") String estado) {
        return ResponseEntity.ok(statusServicosService.findStatusServicoByEstados(estado));
    }

    @GetMapping("/get-status-by-data")
    public ResponseEntity<List<StatusServicosNFE>> getStatusServicoByData(@RequestParam("data") LocalDateTime data) {

        return ResponseEntity.ok(statusServicosService.findStatusByData(data));
    }

    @GetMapping("get-status-indisponibilidade-maior")
    public ResponseEntity<StatusServicosNFE> getSatusComMariorIndisponibilidade() {
        return ResponseEntity.ok(statusServicosService.getStatusComMarioIndisponibilidade());
    }

}
