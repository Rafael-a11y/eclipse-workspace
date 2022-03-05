package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Loja;

public class LojaTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Loja americanas = new Loja();
		Loja casasBahia = new Loja();
		Loja bestBuy = new Loja();
		Loja wallmart = new Loja();
//		long start = System.currentTimeMillis();
		DecimalFormat formato = new DecimalFormat("###,###.##");
//		System.out.println("R$" + formato.format(americanas.getPreco()));
//		System.out.println("R$" + formato.format(casasBahia.getPreco()));
//		System.out.println("R$" + formato.format(bestBuy.getPreco()));
//		System.out.println("R$" + formato.format(wallmart.getPreco()));
//		System.out.println("Total em milissegundos: " + (System.currentTimeMillis() - start) + "ms");
		long start = System.currentTimeMillis();
		Future<Double> getPrecoAsync = americanas.getPrecoAsyncTunado();
		Future<Double> getPrecoAsync1 = casasBahia.getPrecoAsyncTunado();
		Future<Double> getPrecoAsync2 = bestBuy.getPrecoAsyncTunado();
		Future<Double> getPrecoAsync3 = wallmart.getPrecoAsyncTunado();
		long end = System.currentTimeMillis();
		System.out.println("Tempo de invoca��o: " + (end - start) + " ms");
		enrrolando();
		//Caso ocorra uma exce��o em qualquer uma das threads, o get() sem par�metro vai ficar esperando pelo produto do
		//processamento, sendo assim, o algor�tmo nunca encerrar�. Por isso, as boas pr�ticas dizem para voc� usar o TimeoutException,
		//pois, ap�s o tempo fornecido esgotar, uma TimeoutException ser� lan�ada e as tarefas encerrdas devidamente. Mas,
		//o que fazer num cen�rio onde voc� n�o pode mudar o m�todo get(), onde o get() sem par�metro deve ser usado, onde
		//o objeto Future<> deve ficar esperando, para resolver isso, voc� deve usar um try/catch no lugar onde ocorre a 
		//Exception.
		try {
			System.out.println("americanas " + formato.format(getPrecoAsync.get(3, TimeUnit.SECONDS)));
			System.out.println("casasBahia " + formato.format(getPrecoAsync1.get(3, TimeUnit.SECONDS)));
			System.out.println("bestBuy " + formato.format(getPrecoAsync2.get(3, TimeUnit.SECONDS)));
			System.out.println("wallmart " + formato.format(getPrecoAsync3.get(3, TimeUnit.SECONDS)));
		}
		catch(InterruptedException | ExecutionException | TimeoutException e ) {
			e.printStackTrace();
		}
		System.out.println("Tempo que levou para pegar o resultado: " + (System.currentTimeMillis() - start) + "ms");
	}
	private static void enrrolando() {
		long soma = 0;
		for(int i = 0; i< 1_000_000; i++) soma += i;
		System.out.println(soma);
	}
}
