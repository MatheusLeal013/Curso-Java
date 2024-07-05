package model.exceptions;

public class DomainException extends Exception {
	// Tipo serializable - precisa ter uma versão
	private static final long serialVersionUID = 1L;

	// Permitir que eu possa instanciar minha exceção personalizada, passando uma
	// mensagem pra ela
	public DomainException(String msg) {
		super(msg);
	}
}
