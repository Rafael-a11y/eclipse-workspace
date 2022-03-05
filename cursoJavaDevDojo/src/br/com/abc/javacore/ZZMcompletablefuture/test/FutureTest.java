package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	//Introdu��o ao Future, para fazer processamento ass�ncrono, onde tal computa��o � computada em uma thread separada do
	//usu�rio, para que assim, o programa tenha mais interatividade com o usu�rio, e o mesmo n�o fique preso a um algor�timo
	//que fa�a apenas uma tarefa por vez.
	//A classe Executors implementa a interface ExecutorService.
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		//Forma antiga. Aten��o, o Callable � do pacote concurrent. submit() retorna um Future representando as resultados pendentes
		//da tarefa, o m�todo get do Future, retornar� os resultados das tarefas ap�s sua conclus�o bem suscedida. Este m�todo
		//n�o espera por tarefas enviadas anteriormente para concluir a execu��o. Use awaitTermination para fazer isso.
		Future<Double> future = executorService.submit(new Callable<Double>() {
			@Override
			public Double call() throws InterruptedException{
				TimeUnit.SECONDS.sleep(4);
				return 2000D;
			}
		});
		enrrolando();
		//get(timeout, unit) espera se necess�rio, o m�ximo de tempo para que o processamneto seja completo, e em seguida o
		//captura, tamb�m h� o get(), que simplesmente faz a mesma coisa, com a diferen�a que este bloqueia enquanto o processamento
		//n�o for conclu�do.
		//isDone() retorna true se a tarefa estiver completa, e falso caso esteja em computa��o. Enquanto a tarefa n�o estiver
		//termninada, o get(timeout, unit) � chamado, e recebe de par�metro 2 segundos de espera, o que de forma l�gica � p�ssimo,
		//pois, se o get(timeout, unit) est� dentro de um while que o prende at� que a tarefa seja conclu�da, sendo assim, 
		//usar um get() que espera por alguns segundos � desnecess�rio e s� vai custar Exceptions e mais processsamento, o mais
		//adequado � o get() sem par�metro, pois ele espera at� que a tarefa seja conclu�da, que tamb�m � irredundante, se o get
		//j� espera pelo processamento ser conclu�do, n�o tem porqu� chamar o get() dentro de um while que espere a tarefa ser conclu�da
		while(!future.isDone()) {
			Double resultado = future.get(2, TimeUnit.SECONDS);
			System.out.println(resultado);
		}
		//shutDown() termina de forma ordenada, as tarefas enviadas anteriormente, e rejeita qualquer nova tarefa.
		//shutdown() termina as tarefas mesmo que aconte�a uma Exception
		executorService.shutdown();
		//Para finalizar, processamento ass�ncrono � quando determinada tarefa � executada um thread separada, sem afetar ou
		//atrapalhar a thread do usu�rio, sem fazer com que a thread main fique em estado de espera. A seguir, vamos estudar o 
		//CompetableFuture, que � mais completo e f�cil de se usar.
	}
	private static void enrrolando() {
		long soma = 0;
		for(int i = 0; i < 1_000_000; i++) {
			soma += i;
		}
		System.out.println(soma);
	}
}
