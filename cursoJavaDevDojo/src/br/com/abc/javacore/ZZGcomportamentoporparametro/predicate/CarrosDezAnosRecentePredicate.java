package br.com.abc.javacore.ZZGcomportamentoporparametro.predicate;

import java.util.Calendar;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

public class CarrosDezAnosRecentePredicate implements CarroPredicate{

	public CarrosDezAnosRecentePredicate() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean teste(Carro carro) {
		return carro.getAno() <= (Calendar.getInstance().get(Calendar.YEAR) - 10);
	}

}
