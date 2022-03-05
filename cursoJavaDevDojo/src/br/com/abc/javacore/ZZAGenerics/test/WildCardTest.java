package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal{
		
		public abstract void consulta();
	}
	
	class Cachorro extends Animal implements Comparable<Cachorro>{
		@Override
		public void consulta() {
			System.out.println("Consultando cachorro.");
		}

		@Override
		public int compareTo(Cachorro o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String toString() {
			return "Cachorro  {Há um cachorro aqui }";
		}
		
		
	}
	
	class Gato extends Animal{
		@Override
		public void consulta() {
			System.out.println("Consultando gato.");
		}
	}
	
	public class WildCardTest {

		public static void main(String[] args) {
			
			/*Ao fornecer de parâmetro um array de gatos ou cães, induziu-se polimorfismo, mas o mesmo não acontece com
			 * Collections, se o parâmetro é uma list de Animal, então a lista que serve de parâmetro deve ser do tipo
			 * Animal, embora nada impeça de uma lista Animal agrupar objetos de sub-classes*/
			
			Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
			Gato[] gatos = {new Gato(), new Gato()};
//			consultarAnimais(cachorros);
//			consultarAnimais(gatos);
			List<Cachorro> cachorroList = new ArrayList<>();
			cachorroList.add(new Cachorro());
			List<Gato> gatoList = new ArrayList<>();
			gatoList.add(new Gato());
			List<Animal> animalList = new ArrayList<>();
			animalList.add(new Cachorro());
			
			consultarAnimaisList(cachorroList);
			consultarAnimaisList(gatoList);
			consultarAnimaisList(animalList);
			ordenarLista(cachorroList);
		}
		
		public static void consultarAnimais(Animal[] animals) {
			
			for(Animal animal : animals) {
				animal.consulta();
			}
//			animals[1] = new Gato();
		}
		/*Caracter coringa -> desta maneira, vocxê consegue dar de parâmetro uma lista de sub-classes de Animal, mas em contra
		partida, não pode adicionar nada. Lembrando que o generics funciona em tempo de compilação apenas, significa que o
		Java não saberá na hora que a coleção estará restrita apenas ao tipo especificado, pór isso que a restrição de impedir
		que no momento de passar a coleção de parâmetro, somente uma lista do tipó Animal será aceita, para garantir que não
		haja complicações na execução do programa */
		public static void consultarAnimaisList(List<? extends Animal> animals) {
			
			for(Animal animal : animals) {
				animal.consulta();
			}
//			animals.add(new Cachorro());
			
		}
		
		
		/*Aceita Cachorro ou uma super classe de cachorro, inclusive adicionar novos cães. Mas não
		 * permite adicionar um Animal a lista*/
		public static void consultarCachorro(List<? super Cachorro> cachorroList) {
			Cachorro c1 = new Cachorro();
			Animal c2 = new Cachorro();
			Object o = new Cachorro();
			cachorroList.add(c1);	
			
		}
		/*Serve para, caso você queira chamar o próprio método sort(), mas queira aceitar somente
		 * Listas que sejam  um Comparable, assim ele só funciona em Listas que implementem Comparable*/
		public static void ordenarLista(List<? extends Comparable> lista) {
			Collections.sort(lista);
		}
		
	}
