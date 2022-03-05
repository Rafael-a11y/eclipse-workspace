package br.com.abc.javacore.Wio.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {

	public static void main(String[] args) {
		File file = new File("BufferedTest.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
				BufferedReader br = new BufferedReader(new FileReader(file));) {
			bw.write("Escrevendo uma mensagem no arquivo");
			bw.newLine();
			bw.write("E pulando uma linha3");
			bw.newLine();//Funciona para usar o comando de quebra de linha de qualquer SO
			bw.flush();
			
			String s = null;
			/*Enquanto s receber br.readLine()*/
			while(( s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
