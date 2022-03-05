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
	//Caso uma exce��oo ocorra em calcularPreco(), por conta do 1 / 0, o m�todo complete() nunca ser� executado, sendo assim,
	//o m�todo get() sem par�metro vai ficar esperando eternamente, e o programa nunca encerrar�, as exce��es v�o ocorrer 
	//nas 04 threads, e nenhuma das tarefas ser�o conclu�das.
	public Future<Double> getPrecoAsync(){
		CompletableFuture<Double> precoFuturo = new CompletableFuture<Double>();
		new Thread(() -> {
			try {
				precoFuturo.complete(calcularPreco());
			}
			catch(Exception e) {
				//E aqui, voc� deve usar o m�todo completeExceptionnally, onde "o processamento � completado de forma exceptional",
				//piadas a parte. Se ainda n�o estiver conclu�do, faz com que as invoca��es de get () e m�todos relacionados gerem a exce��o fornecida.
				//Par�metros: ex, a exce��o.
				//Retorna verdadeiro se esta invoca��o fez com que este CompletableFuture fizesse a transi��o para um estado conclu�do, caso contr�rio, falso.
				//E agora sim, conseguimos encerrar devidamente o programa, as tarefas foram finalizadas
				precoFuturo.completeExceptionally(e);	
			}
		}).start();
		return precoFuturo;
	}
	//getPrecoAsyncTunado() substitui toda a verbosidade que temos que escrever em getPrecoAsync(), retornamos o p�rprio 
	//container CompletableFuture com o valor Double. Isso acontece porque o m�todo supplyAsync(Supplier<U>) que faz toda
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
