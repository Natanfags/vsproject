package com.example.demo.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum Status {
    VERMELHOR(1, "Negativo"),
    VERDE(2, "Positivo"),
    AMARELO(3, "Itermitente");

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
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
