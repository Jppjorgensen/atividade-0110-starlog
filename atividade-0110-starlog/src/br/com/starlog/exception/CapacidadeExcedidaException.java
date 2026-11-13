package br.com.starlog.exception;

/**
 * RN05: excecao checada (herda de Exception), o compilador obriga a tratar.
 */
public class CapacidadeExcedidaException extends Exception {

    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
