package com.example.demo.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum Status {
    VERMELHA("vermelha"),
    VERDE( "verde"),
    AMARELA( "amarela");

    private final String descricao;

    public static Status toEnum(String descricao) {

        if (Objects.isNull(descricao)) {
            return null;
        }

        for (Status status : Status.values()) {
            if (descricao.equals(status.getDescricao())) {
                return status;
            }
        }
        throw new IllegalArgumentException("descricao inválida: " + descricao);
    }
}
