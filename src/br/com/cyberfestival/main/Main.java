package br.com.cyberfestival.main;

import br.com.cyberfestival.model.Bilheteria;
import br.com.cyberfestival.model.Ingresso;
import br.com.cyberfestival.model.IngressoInvalido;

public class Main {
    public static void main(String[] args) {
        //instancia a bilheteria
        Bilheteria bilheteria = new Bilheteria();

        //cria os 3 ingressos, incluindo o clone do cambista
        Ingresso ingresso1 = new Ingresso("A-01", "VIP", 500.00);
        Ingresso ingresso2 = new Ingresso("A-02", "PISTA", 200.00);
        Ingresso ingresso3 = new Ingresso("A-01", "PISTA", 200.00); //clone com o mesmo codigo A-01

        //faz a venda dos 2 ingressos
        bilheteria.venderIngresso(ingresso1);
        bilheteria.venderIngresso(ingresso2);

        //tentativa de vender o ingresso clonado
        try {
            bilheteria.venderIngresso(ingresso3);
        } catch (IngressoInvalido e) {
            //imprime o alerta de forma limpa sem crashar o sistema
            System.out.println("[ALERTA] " + e.getMessage());
        }

        //imprime o valor da receita VIP (apenas deve retornar 500)
        double receitaVIP = bilheteria.calcularReceitaVIP();
        System.out.println("Receita VIP total: R$ " + receitaVIP);
    }
    
}
