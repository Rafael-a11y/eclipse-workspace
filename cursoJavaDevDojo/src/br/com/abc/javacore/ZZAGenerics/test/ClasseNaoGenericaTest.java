package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZAGenerics.classes.Carro;
import br.com.abc.javacore.ZZAGenerics.classes.Computador;

public class ClasseNaoGenericaTest {

	public static void main(String[] args) {
		CarroAlugavel carroAlugavel = new CarroAlugavel();
		Carro carroAlugado = carroAlugavel.getCarroDisponivel();
		System.out.println("Usando o carro por um m�s");
		carroAlugavel.devolverCarro(carroAlugado);
		
		System.out.println("-------------------------------------------------------------------"
				+ "-----------");
		ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
		Computador computador = computadorAlugavel.getComputadorDisponivel();
		System.out.println("Usando o PC");
		computadorAlugavel.devolverComputador(computador);
	}
}
	
	class CarroAlugavel{
		
		private List<Carro> carrosDisponiveis = new ArrayList<Carro>();
		
		{
			carrosDisponiveis.add(new Carro("Gol"));
			carrosDisponiveis.add(new Carro("BMW"));
		}
		
		public Carro getCarroDisponivel() {
			Carro c = carrosDisponiveis.remove(0);
			System.out.println("Alugando carro: " + c);
			System.out.println("Carros dispon�veis: " + carrosDisponiveis); 
			return c;
		}
		
		public void devolverCarro(Carro c) {
			System.out.println("Devolvendo carro " + c);
			carrosDisponiveis.add(c);
			System.out.println("Carros dispon�veis: " + carrosDisponiveis); 
		}
	}
	
class ComputadorAlugavel{
		
		private List<Computador> computadoresDisponiveis = new ArrayList<Computador>();
		
		{
			computadoresDisponiveis.add(new Computador("Alienware"));
			computadoresDisponiveis.add(new Computador("HP"));
		}
		
		public Computador getComputadorDisponivel() {
			Computador c = computadoresDisponiveis.remove(0);
			System.out.println("Alugando PC: " + c);
			System.out.println("PC�s dispon�veis: " + computadoresDisponiveis); 
			return c;
		}
		
		public void devolverComputador(Computador c) {
			System.out.println("Devolvendo PC: " + c);
			computadoresDisponiveis.add(c);
			System.out.println("PC�s dispon�veis: " + computadoresDisponiveis); 
		}
	}