package br.com.abc.javacore.ZZEconcorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
/*Se um dia você se perguntar: Como faço para agendar uma tarefa para uma thread de tanto em tanto tempo? Quando isso acontecer
 * você vai usar Executors.newScheduledThreadPool(), ele retorna um ScheduledExecutorService. Com o objeto ScheduledExecutorService
 * criado, você deve usar o método schedule(Runnable object, int unit, TimeUnit enum), ele executa a thread especificada de for
 * ma intercalada pelo tempo especificado, ou seja, a cada 5 segundos por exemplo.*/
	private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
//	private static TimeUnit time = TimeUnit.SECONDS;
	private static void beep() {
		long incrementa = 0L;
		final Runnable beeper = new Runnable (){
			int contador = 0;
			@Override 
			public void run() {
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					Date date = new Date();
					String hora = sdf.format(date);
					System.out.println(hora + " beep");
//					try {
//						TimeUnit.SECONDS.sleep(0);
//					} catch (InterruptedException e) {
//						System.out.println("Aconteceu um erro -> " + e.getMessage());
//						e.printStackTrace();
//					}
					
			}
		};
		/*scheduleAtFixedRate começa a contar o tempo mesmo com o delay de processamento, ou seja, se você define que a thread
		 * será executada de 1 em 10 segundos e põe a thread para dormir por 5 segundos, após a thread acordar serão contados
		 * mais 5 segundos e a thread é repetida. scheduleWithFixedDelay conta o tempo sem considerar o tempo de delay, ou seja,
		 * aplicando o mesmo cenário citado anteriormente, a thread será repetida de 15 em 15 segundos, pois ela vai dormir 5
		 * segundos, e só depois de acordar que o scheduled irá começar o contagem*/
//		scheduledExecutorService.scheduleAtFixedRate(beeper, 5, 2, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(beeper, 2, 2, TimeUnit.SECONDS);
		/*Deve criar outra Runnable para chamar o chtDow após o tempo determinado*/
		scheduledExecutorService.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("Cancelando");
				scheduledExecutorService.shutdown();
			}
		}, 11, TimeUnit.SECONDS);
	}
	public ScheduledThreadPoolTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println("Início");
		beep();
		System.out.println("Fim");
	}
}
