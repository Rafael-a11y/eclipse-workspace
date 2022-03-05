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
		/*Primeiro, deve criar uma pscina de threads a partir da classe Executors, com o método estático newFixedThreadPool,
		 * passando como parâmetro o número de threads que será criado, esse método retorna um ExecutorService, então é uma
		 * boa prática criar a variável de mesmo tipo. Depois chame o método execute() passando o objeto que implementa Runnable,
		 * é importante lembrar que a quantidade de vezes que você deve chamar o método é a mesma quantidade passada de parâmetro
		 * no newFixedThreadPool, caso você só crie uma Thread (ao usar o método execute), essa thread vai executar o run() pelas
		 * outras threads que deveriam existir, isso se não ficar em dead lock, de qulquer forma não é recomendável fazer isso,
		 * exemplo: se você cria uma piscina de Threads para quatro threads, então você deve chamar o execute 4 vezes, caso 
		 * contrário a thread criada vai  executar 4 vezes. Caso você crie um pool de threads com um número inferior ao de 
		 * threads criadas, as threadas vão executar o run(), o main também vai executar todas as linhas, mas o programa não 
		 * encerra, provavelmente fica em um dead lock. Então, se você criar mais tarefas do que o número de threads do pool
		 * de threads, elas serão reproveitadas, por isso não atingirão o estado de conclusão, pois não passaram pelo estado
		 * de iniciação
		 * */
		System.out.println("Número de processadores: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Criando o pool de threads para 4 threads");
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		/*newCachedThreadPool cria um pool de threads mas sem um tamanho fixo, a medida que ir precisando, ele vai criando
		 * as threads, e faz remoção das threads que ficarem ociosas por 60 segundos, elas são removidas do pool dwe threads.
		 * newSingleThreadExecutor cria apenas uma thread, e as tarefas que não podem ser executadas são colocadas em uma Queue
		 * sem limites. A diferença dele para o newFixedThreadPool? É que você não pode alterar o número de threads
		 *   */
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();	
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
		System.out.println("Alterando em tempo de execução o máximo de threads permitidas para 6");
		threadPoolExecutor.setMaximumPoolSize(6);
		executorService.execute(new ThreadTrabalhadoraExecutor("1"));
		executorService.execute(new ThreadTrabalhadoraExecutor("2"));
		executorService.execute(new ThreadTrabalhadoraExecutor("3"));
		executorService.execute(new ThreadTrabalhadoraExecutor("4"));
		executorService.execute(new ThreadTrabalhadoraExecutor("5"));
		executorService.execute(new ThreadTrabalhadoraExecutor("6"));
		System.out.println("Alterando em tempo de execução o número de threads para 6");
		threadPoolExecutor.setCorePoolSize(6);
		executorService.shutdown();
		while(!executorService.isTerminated()) {}
		System.out.println("Terminou? " + executorService.isTerminated());
		//Para saber quantos processadores possui a máquina em questão
		System.out.println(Thread.currentThread().getName());
		System.out.println("Finalizado");
	}
}