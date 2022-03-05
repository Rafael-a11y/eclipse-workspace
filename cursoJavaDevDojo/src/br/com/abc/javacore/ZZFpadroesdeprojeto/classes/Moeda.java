package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

public interface Moeda {

	public abstract String getSimbolo();
	
class Real implements Moeda{
	@Override
	public String getSimbolo() {
			return "R$";
		}
	}
}

class U$Dolar implements Moeda{
	
	@Override
	public String getSimbolo() {
		return "U$D";
	}
}