package br.com.cyberfestival.model;

public class IngressoInvalido extends RuntimeException {
    public IngressoInvalido() {
        super("Erro de segurança: ingresso duplicado ou código já validado!");
    }
}
