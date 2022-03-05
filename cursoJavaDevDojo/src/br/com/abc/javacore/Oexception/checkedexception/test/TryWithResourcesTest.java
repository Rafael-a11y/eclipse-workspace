package br.com.abc.javacore.Oexception.checkedexception.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import br.com.abc.javacore.Oexception.checkedexception.classes.Leitor1;
import br.com.abc.javacore.Oexception.checkedexception.classes.Leitor2;

public class TryWithResourcesTest {
	
	public static void main(String[] args) throws IOException{
	
		lerArquivo();
	}
	
	public static void lerArquivo() throws IOException {
		try(Leitor1 leitor1 = new Leitor1();
				Leitor2 leitor2 = new Leitor2()){
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoOld() {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader("text.txt"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
