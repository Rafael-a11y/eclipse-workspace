package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
	private String nome;
	public Loja(String nome) {
		this.nome = nome;
	}
	public Loja() {
		
	}
	
	public double getPreco() {
		//Vai pegar onde Judas bateu as botas.
		return calcularPreco();
	}
	//Caso uma exceçãoo ocorra em calcularPreco(), por conta do 1 / 0, o método complete() nunca será executado, sendo assim,
	//o método get() sem parâmetro vai ficar esperando eternamente, e o programa nunca encerrará, as exceções vão ocorrer 
	//nas 04 threads, e nenhuma das tarefas serão concluídas.
	public Future<Double> getPrecoAsync(){
		CompletableFuture<Double> precoFuturo = new CompletableFuture<Double>();
		new Thread(() -> {
			try {
				precoFuturo.complete(calcularPreco());
			}
			catch(Exception e) {
				//E aqui, você deve usar o método completeExceptionnally, onde "o processamento é completado de forma exceptional",
				//piadas a parte. Se ainda não estiver concluído, faz com que as invocações de get () e métodos relacionados gerem a exceção fornecida.
				//Parâmetros: ex, a exceção.
				//Retorna verdadeiro se esta invocação fez com que este CompletableFuture fizesse a transição para um estado concluído, caso contrário, falso.
				//E agora sim, conseguimos encerrar devidamente o programa, as tarefas foram finalizadas
				precoFuturo.completeExceptionally(e);	
			}
		}).start();
		return precoFuturo;
	}
	//getPrecoAsyncTunado() substitui toda a verbosidade que temos que escrever em getPrecoAsync(), retornamos o pórprio 
	//container CompletableFuture com o valor Double. Isso acontece porque o método supplyAsync(Supplier<U>) que faz toda
	//essa parte de criar um thread, envolver o valor com o complete(), etcetera.
	public Future<Double> getPrecoAsyncTunado(){
		return CompletableFuture.supplyAsync(this::calcularPreco);
	}
	private double calcularPreco() {
		delay();
//		System.out.println(1 / 0);
		return ThreadLocalRandom.current().nextDouble() * 100;
	}
	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
