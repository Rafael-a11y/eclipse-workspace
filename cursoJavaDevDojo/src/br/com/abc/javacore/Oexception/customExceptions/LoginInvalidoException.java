package br.com.abc.javacore.Oexception.customExceptions;

public class LoginInvalidoException extends Exception {

	public LoginInvalidoException() {
		super("Usuário ou senha inválidos");
	}

}
