package com.example.demo.entity.dto;

import com.example.demo.entity.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StatusServicosDTO {

    private LocalDateTime data;

    private String autorizador;

    private Status status;
}
