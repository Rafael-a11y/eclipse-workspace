package br.com.abc.javacore.ZZGcomportamentoporparametro.test;
//Import estatic serve para importar somente o metodo estatico
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
import br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces.CarroPredicate;
public class CarroTest {
	
	private static List<Carro> filtrarCarroVerde(List<Carro> carros){
		List<Carro> result = new ArrayList<Carro>();
		for(Carro carro : carros) {
			if(carro.getCor().equals("verde")){
				result.add(carro);
			}
		}
		return result;
	}
	private static List<Carro> filtrarCarroPorCor(List<Carro> carros, String cor){
		List<Carro> result = new ArrayList<Carro>();
		for(Carro carro : carros) {
			if(carro.getCor().equalsIgnoreCase(cor)){
				result.add(carro);
			}
		}
		return result;
	}
	private static List<Carro> filtrarCarrosDezAnosFabricados(List<Carro> carros){
		List<Carro> result = new ArrayList<>();
		for(Carro carro : carros) {
			if(carro.getAno() <= (Calendar.getInstance().get(Calendar.YEAR) - 10)){
				result.add(carro);
			}
		}
		return result;
	}
	private static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate) {
		List<Carro> result = new ArrayList<>();
		for(Carro carro : carros) {
			if(carroPredicate.teste(carro)) {
				result.add(carro);
			}
		}
		return result;
	}
	//Usa-se T antes da lista
	public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate){
		List<T> result = new ArrayList<>();
		for(T e : list) {
			if(predicate.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<Carro> carros = asList(new Carro("vermelho", 2011), new Carro("verde", 1995), new Carro("preto", 2017));
		List<Integer> numeros = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		System.out.println(filtrarCarroPorCor(carros, "verde"));
//		System.out.println(filtrarCarroPorCor(carros, "vermelho"));
//		System.out.println(filtrarCarrosDezAnosFabricados(carros));
//		Usando uma classe an?nima, para conseguir sobrescrever o m?todo da interface sem precisar criar uma nova class
//		implementadora, por?m, ter que sobrescrever toda vez ? um saco
//		System.out.println(filtrarCarros(carros, new CarroPredicate() {
//			@Override
//			public boolean teste(Carro carro) {
//				return carro.getCor().equalsIgnoreCase("verde");
//			}
//		}));
//		System.out.println(filtrarCarros(carros, new CarroPredicate() {
//			public boolean teste(Carro carro) {
//				return carro.getAno() <= ((Calendar.getInstance().get(Calendar.YEAR) - 10));
//			}
//		}));
//		Usando uma lambda, engra?ado que ela n?o precisa ser esperada para ser usada, ? uma fun??o sem nome que substitui o
//		trabalho de criar uma classe an?nima, tem que ser escrita quando quiser usa-la para n?o ter que criar uma nova classe
//		implementadora de CarroPredicate, mas ? muito mais simples de se ler e escrever
//		System.out.println(filtrarCarros(carros, carro -> carro.getAno() <= ((Calendar.getInstance().get(Calendar.YEAR))- 10)));
//		Usando um m?todo gen?rico filtrar(List<T> list, Predicate<T> predicate)
//		System.out.println(filtrar(numeros, new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer integer){
//				return integer % 2 == 0;
//			}
//		}));
	}
}
