package br.com.cyberfestival.model;

import java.util.HashMap;
import java.util.Map;

public class Bilheteria {
    // banco de dados em memoria, chave é o codigo id
    private Map<String, Ingresso> ingressosVendidos = new HashMap<>();
    
    // vender ingresso com validação de duplicidade
    public void venderIngresso(Ingresso ingresso) {
        if (ingressosVendidos.containsKey(ingresso.getCodigoId())){
            throw new IngressoInvalido();
        }
        ingressosVendidos.put(ingresso.getCodigoId(), ingresso);
    }

    //contabilidade em tempo real usando apenas streams
    public double calcularReceitaVIP() {
        return ingressosVendidos.values().stream().filter(i -> "VIP".equals(i.getTipo())).mapToDouble(Ingresso::getValor).sum();
    }

}
