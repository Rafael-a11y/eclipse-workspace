package swing.provaav1;

import java.util.Arrays;
import java.util.List;

public class Barao {

	private List<Carro> carros = Arrays.asList(new Carro("Lamborguini", 2000),
		new Carro("Fusca", 600),
		new Carro("McLaren", 2100),
		new Carro(),
		new Carro("Fiat", 1000),
		new Carro("Mercedes", 2200),
		new Carro("Sandero", 1600));
	
	public List<Carro> getCarros(){
		return this.carros;
	}
}
