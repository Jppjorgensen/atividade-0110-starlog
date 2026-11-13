package br.com.starlog.model;

import java.util.Locale;
import java.util.Objects;

/**
 * Entidade Carga: cada carga e identificada pelo seu codigo de rastreio.
 */
public class Carga {

    // RN01: o codigo de rastreio e final e nao tem setter (identidade imutavel)
    private final String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        // RN02: fail-fast, valida tudo ANTES de atribuir
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");
        }
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso da carga deve ser maior que zero.");
        }
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    // RN03: equals e hashCode usam SOMENTE o codigo de rastreio
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carga carga = (Carga) o;
        return Objects.equals(codigoRastreio, carga.codigoRastreio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoRastreio);
    }

    // RN04: representacao textual no formato pedido
    @Override
    public String toString() {
        return String.format(Locale.US, "Carga [rastreio=%s, categoria=%s, peso=%.1fkg, seguro=R$ %.2f]",
                codigoRastreio, categoria, pesoKg, valorSeguro);
    }
}
