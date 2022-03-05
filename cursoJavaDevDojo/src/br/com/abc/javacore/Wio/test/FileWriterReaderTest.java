package br.com.abc.javacore.Wio.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {

	public static void main(String[] args) {
		
		File file = new File("ArquivoFileWriterReader.txt");
		try(FileWriter fw = new FileWriter(file, true);
				FileReader fr = new FileReader(file);){
			fw.write("Escrevendo no arquivo...\npulando uma linha3...");		
			System.out.println(file.getAbsolutePath());
			fw.flush(); //leitura
			
			char[] in = new char[10000];
			int size = fr.read(in);
			System.out.println("Tamanho:" + size);
			for(char c : in) {
				System.out.print(c);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
//		try {
//			FileWriter fw = new FileWriter(file, true);
//			
//			fw.close();//escrita e leitura
//			
//			FileReader fr = new FileReader(file);
//			char[] in = new char[10000];
//			int size = fr.read(in);
//			System.out.println(size);
//			for(char c : in) {
//				System.out.print(c);
//			}
//			fr.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
