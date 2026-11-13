package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia os modulos da base. O Map permite achar um modulo pelo id em O(1).
 */
public class BaseLancamento {

    // RN09: chave = id do modulo, valor = o proprio modulo
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public void cadastrarModulo(ModuloCarga modulo) {
        modulos.put(modulo.getIdModulo(), modulo);
    }

    public ModuloCarga buscarModulo(String idModulo) {
        return modulos.get(idModulo);
    }
}
