package com.example.demo.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum Status {
    VERMELHA(1, "vermelha"),
    VERDE(2, "verde"),
    AMARELA(3, "amarela");

    private final int cod;
    private final String descricao;

    public static Status toEnum(Integer cod) {

        if (Objects.isNull(cod)) {
            return null;
        }

        for (Status status : Status.values()) {
            if (cod.equals(status.getCod())) {
                return status;
            }
        }
        throw new IllegalArgumentException("codigo inválido: " + cod);
    }
}
