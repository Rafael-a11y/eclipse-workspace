package br.com.abc.javacore.Minterfaces.classes;

public interface Tributavel {
	
	/*Atributos de uma Interfacxe sempre ser�o p�blicos, est�ticos e finais (constantes), obviamente, precisam ser 
	 * inicializados*/
	public static final double IMPOSTO = 0.2;
	
	public abstract void calculaImposto();

}
