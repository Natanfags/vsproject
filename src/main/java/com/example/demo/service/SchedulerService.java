package com.example.demo.service;

import com.example.demo.entity.StatusServicosNFE;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchedulerService {

    private final StatusServicosService statusServicosService;

    @Scheduled(cron = "0 */5 * * * *")
    public void salvarStatusACadaCincoMinutos() {
        List<StatusServicosNFE> servicosFromUrl = this.statusServicosService.createServicosFromUrl();
        this.statusServicosService.saveAll(servicosFromUrl);
    }
}
