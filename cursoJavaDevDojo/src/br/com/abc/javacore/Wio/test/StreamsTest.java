package br.com.abc.javacore.Wio.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamsTest {

	public static void main(String[] args) {
	/*BuferedOutputStream serve para uma melhor performance de escrita, claro que com tão poucos, essa diferença não é visível
	 * FileInputStream serve para leitura de dados*/
	gravadorTunado();
	leitorTunado();
	}
	/*As classes de stream automáticamente criam o arquivo*/
	private static void gravador() {
		byte[] dados = {70,73,76,72,65,95,68,65,95,80,85,84,65, 0};
		try (FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")){
			gravador.write(dados);
			gravador.flush();
			System.out.println("Dados gravados com sucesso!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void gravadorTunado() {
		byte[] dados = {70,73,76,72,65,95,68,65,95,80,85,84,65, 0};
		try (BufferedOutputStream gravadorBuffer =  new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"), 4098)){
			gravadorBuffer.write(dados);
			gravadorBuffer.flush();
			System.out.println("Dados gravados com sucesso!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void leitor() {
		try(FileInputStream leitor = new FileInputStream("pasta/stream.txt")){
			int leitura;
			while((leitura = leitor.read()) != -1) {
				/*Somente por uma questão de otimização e economia de memória em uso*/
				byte b = (byte) leitura;
				System.out.println(" " + b);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void leitorTunado() {
		try(BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"),4098)){
			int leitura;
			while((leitura = leitorBuffer.read()) != -1) {
				/*Somente por uma questão de otimização e economia de memória em uso*/
				byte b = (byte) leitura;
				System.out.println(" " + b);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void leitor2() {
		try(FileInputStream leitor = new FileInputStream("pasta/stream.txt")){
			int leitura;
			while((leitura = leitor.read()) != -1)
			System.out.println(" " + leitura);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
