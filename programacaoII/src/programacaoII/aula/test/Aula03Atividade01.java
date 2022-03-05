package programacaoII.aula.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import programacaoII.aula.classes.Atleta;
import programacaoII.aula.classes.Atleta.Esporte;

public class Aula03Atividade01 {

	public static void main(String[] args) {
		
		List atletas = Arrays.asList(new Atleta("Serena Williams", Esporte.Tenis), 
				new Atleta("Lewis Hamilton", Esporte.F1), new Atleta("Lionel Messi", Esporte.Futebol), 
				new Atleta("Serena Williams", Esporte.Tenis), new Atleta("Marta", Esporte.Futebol),
				new Atleta("Lebrom James", Esporte.Basquete), new Atleta("Venus Williams", Esporte.Basquete),
				new Atleta("Kawhi Leonard", Esporte.F1));
		for(Object atleta : atletas) {
			System.out.println(atleta);
		}
	}
}
