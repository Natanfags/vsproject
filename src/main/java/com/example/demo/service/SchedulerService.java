package com.example.demo.service;

import com.example.demo.entity.StatusServicosNFE;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchedulerService {

    @Setter
    private StatusServicosService statusServicosService;

    @Scheduled(cron = "0 */1 * * * *")
    public void salvarStatusACadaCincoMinutos() {
        List<StatusServicosNFE> servicosFromUrl = this.statusServicosService.createServicosFromUrl();
        this.statusServicosService.saveAll(servicosFromUrl);
    }
}
