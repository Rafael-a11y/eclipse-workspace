package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadTrabalhadoraExecutor implements Runnable{
	private String num ;
	
	public ThreadTrabalhadoraExecutor(String num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " iniciou " + num);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " finalizou");
	}
}

public class ExecutorTest {
	public static void main(String[] args) {
		/*Primeiro, deve criar uma pscina de threads a partir da classe Executors, com o m�todo est�tico newFixedThreadPool,
		 * passando como par�metro o n�mero de threads que ser� criado, esse m�todo retorna um ExecutorService, ent�o � uma
		 * boa pr�tica criar a vari�vel de mesmo tipo. Depois chame o m�todo execute() passando o objeto que implementa Runnable,
		 * � importante lembrar que a quantidade de vezes que voc� deve chamar o m�todo � a mesma quantidade passada de par�metro
		 * no newFixedThreadPool, caso voc� s� crie uma Thread (ao usar o m�todo execute), essa thread vai executar o run() pelas
		 * outras threads que deveriam existir, isso se n�o ficar em dead lock, de qulquer forma n�o � recomend�vel fazer isso,
		 * exemplo: se voc� cria uma piscina de Threads para quatro threads, ent�o voc� deve chamar o execute 4 vezes, caso 
		 * contr�rio a thread criada vai  executar 4 vezes. Caso voc� crie um pool de threads com um n�mero inferior ao de 
		 * threads criadas, as threadas v�o executar o run(), o main tamb�m vai executar todas as linhas, mas o programa n�o 
		 * encerra, provavelmente fica em um dead lock. Ent�o, se voc� criar mais tarefas do que o n�mero de threads do pool
		 * de threads, elas ser�o reproveitadas, por isso n�o atingir�o o estado de conclus�o, pois n�o passaram pelo estado
		 * de inicia��o
		 * */
		System.out.println("N�mero de processadores: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Criando o pool de threads para 4 threads");
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		/*newCachedThreadPool cria um pool de threads mas sem um tamanho fixo, a medida que ir precisando, ele vai criando
		 * as threads, e faz remo��o das threads que ficarem ociosas por 60 segundos, elas s�o removidas do pool dwe threads.
		 * newSingleThreadExecutor cria apenas uma thread, e as tarefas que n�o podem ser executadas s�o colocadas em uma Queue
		 * sem limites. A diferen�a dele para o newFixedThreadPool? � que voc� n�o pode alterar o n�mero de threads
		 *   */
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();	
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
		System.out.println("Alterando em tempo de execu��o o m�ximo de threads permitidas para 6");
		threadPoolExecutor.setMaximumPoolSize(6);
		executorService.execute(new ThreadTrabalhadoraExecutor("1"));
		executorService.execute(new ThreadTrabalhadoraExecutor("2"));
		executorService.execute(new ThreadTrabalhadoraExecutor("3"));
		executorService.execute(new ThreadTrabalhadoraExecutor("4"));
		executorService.execute(new ThreadTrabalhadoraExecutor("5"));
		executorService.execute(new ThreadTrabalhadoraExecutor("6"));
		System.out.println("Alterando em tempo de execu��o o n�mero de threads para 6");
		threadPoolExecutor.setCorePoolSize(6);
		executorService.shutdown();
		while(!executorService.isTerminated()) {}
		System.out.println("Terminou? " + executorService.isTerminated());
		//Para saber quantos processadores possui a m�quina em quest�o
		System.out.println(Thread.currentThread().getName());
		System.out.println("Finalizado");
	}
}