package br.com.starlog.model;

import br.com.starlog.exception.CapacidadeExcedidaException;

import java.util.ArrayList;
import java.util.List;

/**
 * Conteiner fisico que guarda cargas ate o limite da sua capacidade.
 */
public class ModuloCarga {

    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        // RN06: lista criada no construtor para nunca ser nula
        this.cargas = new ArrayList<>();
    }

    // RN07: trava de capacidade; usa >= porque atingir o limite ja bloqueia
    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (this.cargas.size() >= this.capacidadeMaxima) {
            throw new CapacidadeExcedidaException("Capacidade maxima de " + this.capacidadeMaxima
                    + " atingida no modulo " + this.idModulo);
        }
        this.cargas.add(carga);
    }

    // RN08: soma de todos os seguros, sem for e sem if
    public double calcularSeguroTotal() {
        return this.cargas.stream()
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    // RN08: conta quantas cargas sao da categoria informada
    public long contarPorCategoria(String categoria) {
        return this.cargas.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .count();
    }

    // RN08: primeiro filtra as cargas acima do corte, depois soma o seguro delas
    public double calcularSeguroPesadas(double pesoCorte) {
        return this.cargas.stream()
                .filter(c -> c.getPesoKg() > pesoCorte)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    public String getIdModulo() {
        return idModulo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}
