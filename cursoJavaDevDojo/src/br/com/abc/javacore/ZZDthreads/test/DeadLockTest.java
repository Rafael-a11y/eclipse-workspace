package br.com.abc.javacore.ZZDthreads.test;
/*Uma claasse DeadLockTest que cont?m dois objetos est?ticos, junto de uma outra classe est?tica, ou seja, 
 * DeadLockTest.ThreadExemplo1, ThreadExemplo1 extends Thread, dentro do run(), lock1 e lock s?o synchronized*/
public class DeadLockTest {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args) {
		new ThreadExemplo1().start();
		new ThreadExemplo2().start();
	}
	
	private static  class ThreadExemplo1 extends Thread{
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: segurando lock 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 1: esperando pelo lock 2");
				synchronized (lock2) {
					System.out.println("Thread 1: segurando lock 1 e lock 2");
				}
			}
		}
	}
	private static  class ThreadExemplo2 extends Thread{
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 2: segurando lock 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2: esperando pelo lock 2");
				synchronized (lock2) {
					System.out.println("Thread 2: segurando lock 2 e lock 1");
				}
			}
		}
	}

}
