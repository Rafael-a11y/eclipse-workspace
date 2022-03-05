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
			return "Cachorro  {H� um cachorro aqui }";
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
			
			/*Ao fornecer de par�metro um array de gatos ou c�es, induziu-se polimorfismo, mas o mesmo n�o acontece com
			 * Collections, se o par�metro � uma list de Animal, ent�o a lista que serve de par�metro deve ser do tipo
			 * Animal, embora nada impe�a de uma lista Animal agrupar objetos de sub-classes*/
			
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
		/*Caracter coringa -> desta maneira, vocx� consegue dar de par�metro uma lista de sub-classes de Animal, mas em contra
		partida, n�o pode adicionar nada. Lembrando que o generics funciona em tempo de compila��o apenas, significa que o
		Java n�o saber� na hora que a cole��o estar� restrita apenas ao tipo especificado, p�r isso que a restri��o de impedir
		que no momento de passar a cole��o de par�metro, somente uma lista do tip� Animal ser� aceita, para garantir que n�o
		haja complica��es na execu��o do programa */
		public static void consultarAnimaisList(List<? extends Animal> animals) {
			
			for(Animal animal : animals) {
				animal.consulta();
			}
//			animals.add(new Cachorro());
			
		}
		
		
		/*Aceita Cachorro ou uma super classe de cachorro, inclusive adicionar novos c�es. Mas n�o
		 * permite adicionar um Animal a lista*/
		public static void consultarCachorro(List<? super Cachorro> cachorroList) {
			Cachorro c1 = new Cachorro();
			Animal c2 = new Cachorro();
			Object o = new Cachorro();
			cachorroList.add(c1);	
			
		}
		/*Serve para, caso voc� queira chamar o pr�prio m�todo sort(), mas queira aceitar somente
		 * Listas que sejam  um Comparable, assim ele s� funciona em Listas que implementem Comparable*/
		public static void ordenarLista(List<? extends Comparable> lista) {
			Collections.sort(lista);
		}
		
	}
