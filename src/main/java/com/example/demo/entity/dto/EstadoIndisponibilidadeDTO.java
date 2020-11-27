package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class EstadoIndisponibilidadeDTO {

    private String estado;
    private long countStatusVermelho;

    public EstadoIndisponibilidadeDTO(long countStatusVermelho) {
        this.countStatusVermelho = countStatusVermelho;
    }

    public EstadoIndisponibilidadeDTO(long countStatusVermelho, String estado) {
        this.estado = estado;
        this.countStatusVermelho = countStatusVermelho;
    }

}
