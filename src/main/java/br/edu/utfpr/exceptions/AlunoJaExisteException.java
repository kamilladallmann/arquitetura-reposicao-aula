package br.edu.utfpr.exceptions;
/**
 * As classes de exceção apenas chamam a classe superior,
 * sem implementações específicas. Não possui parâmetro Throwable,
 * fazendo com que se perca a causa do erro.
 */
public class AlunoJaExisteException extends Exception {
    public AlunoJaExisteException (String msg){
        super(msg);
    }
}
