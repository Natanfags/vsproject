package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class DashboardStatusServicosDTO {

    private String estado;
    private long statusVerde;
    private long statusVermelho;
    private long statusAmarelo;

    public DashboardStatusServicosDTO(String estado, long statusVerde, long statusVermelho, long statusAmarelo) {
        this.estado = estado;
        this.statusVerde = statusVerde;
        this.statusVermelho = statusVermelho;
        this.statusAmarelo = statusAmarelo;
    }
}
