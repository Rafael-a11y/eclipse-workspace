package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
/*Em ambientes concorrentes, caso queira gerar um valor aleat�rio para cada thread, use a classe ThreadLocalRandom, gera o
 * valor aleat�rio para cada thread, n�o d� problemas com o lock*/
public class CallableTest implements Callable<String> {
	@Override
	public String call(){
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for(int i = 0; i < count; i++) {
			System.out.println(Thread.currentThread().getName() + " executando");
		}
		return "Trabalho realizado, o n�mero aleat�rio �: " + count;
	}
	
	public static void main(String[] args) {
		CallableTest ct = new CallableTest();
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> resultFuture = executorService.submit(ct);
		/*get() espera, se necess�rio, a conclus�o do c�ulculo e em seguida recupera seu resultado*/
		try {
			String s = resultFuture.get();
			System.out.println(s);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		executorService.shutdown();
	}
}
