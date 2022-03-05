package br.com.abc.javacore.ZZGcomportamentoporparametro.predicate;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorVerdePredicate implements CarroPredicate{

	
	public CarrosCorVerdePredicate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean teste(Carro carro) {
		return carro.getCor().equalsIgnoreCase("verde");
	}

}
