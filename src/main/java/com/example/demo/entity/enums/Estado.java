package com.example.demo.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Estado {

    AMAZONAS("Amazonas", "AM"),
    BAHIA("Bahia", "BA"),
    CEARA("Ceará", "CE"),
    GOIAS("Goiás", "GO"),
    MINAS_GERAIS("Minas Gerais", "MG"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"),
    MATO_GROSSO("Mato Grosso", "MT"),
    PERNAMBUCO("Pernambuco", "PE"),
    PARANA("Paraná", "PR"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
    SAO_PAULO("São Paulo", "SP");

    private final String nome;
    private final String sigla;

    public static Estado fromUF(final String nomeUf) {
        for (final Estado uf : Estado.values()) {
            if (uf.nome.equalsIgnoreCase(nomeUf)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(nomeUf);
    }

    public static Estado fromSigla(final String sigla) {
        for (final Estado uf : Estado.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(sigla);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnidadeFederacao{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", sigla='").append(sigla).append('\'');
        sb.append('}');
        return sb.toString();
    }
}