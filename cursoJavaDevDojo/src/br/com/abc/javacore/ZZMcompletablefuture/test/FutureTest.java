package br.com.abc.javacore.ZZMcompletablefuture.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	//Introdução ao Future, para fazer processamento assíncrono, onde tal computação é computada em uma thread separada do
	//usuário, para que assim, o programa tenha mais interatividade com o usuário, e o mesmo não fique preso a um algorítimo
	//que faça apenas uma tarefa por vez.
	//A classe Executors implementa a interface ExecutorService.
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		//Forma antiga. Atenção, o Callable é do pacote concurrent. submit() retorna um Future representando as resultados pendentes
		//da tarefa, o método get do Future, retornará os resultados das tarefas após sua conclusão bem suscedida. Este método
		//não espera por tarefas enviadas anteriormente para concluir a execução. Use awaitTermination para fazer isso.
		Future<Double> future = executorService.submit(new Callable<Double>() {
			@Override
			public Double call() throws InterruptedException{
				TimeUnit.SECONDS.sleep(4);
				return 2000D;
			}
		});
		enrrolando();
		//get(timeout, unit) espera se necessário, o máximo de tempo para que o processamneto seja completo, e em seguida o
		//captura, também há o get(), que simplesmente faz a mesma coisa, com a diferença que este bloqueia enquanto o processamento
		//não for concluído.
		//isDone() retorna true se a tarefa estiver completa, e falso caso esteja em computação. Enquanto a tarefa não estiver
		//termninada, o get(timeout, unit) é chamado, e recebe de parâmetro 2 segundos de espera, o que de forma lógica é péssimo,
		//pois, se o get(timeout, unit) está dentro de um while que o prende até que a tarefa seja concluída, sendo assim, 
		//usar um get() que espera por alguns segundos é desnecessário e só vai custar Exceptions e mais processsamento, o mais
		//adequado é o get() sem parâmetro, pois ele espera até que a tarefa seja concluída, que também é irredundante, se o get
		//já espera pelo processamento ser concluído, não tem porquê chamar o get() dentro de um while que espere a tarefa ser concluída
		while(!future.isDone()) {
			Double resultado = future.get(2, TimeUnit.SECONDS);
			System.out.println(resultado);
		}
		//shutDown() termina de forma ordenada, as tarefas enviadas anteriormente, e rejeita qualquer nova tarefa.
		//shutdown() termina as tarefas mesmo que aconteça uma Exception
		executorService.shutdown();
		//Para finalizar, processamento assíncrono é quando determinada tarefa é executada um thread separada, sem afetar ou
		//atrapalhar a thread do usuário, sem fazer com que a thread main fique em estado de espera. A seguir, vamos estudar o 
		//CompetableFuture, que é mais completo e fácil de se usar.
	}
	private static void enrrolando() {
		long soma = 0;
		for(int i = 0; i < 1_000_000; i++) {
			soma += i;
		}
		System.out.println(soma);
	}
}
