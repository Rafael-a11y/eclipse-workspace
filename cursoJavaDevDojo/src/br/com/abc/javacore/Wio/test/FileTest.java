package br.com.abc.javacore.Wio.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiFunction;


public class FileTest {

	public static void main(String[] args) {
		Calendar calendar = null;
		DateFormat dateFormat = null;
		Date dateParametro = null;
		BiFunction<Date, File, String> dataFormatada = (d, f) -> { d = new Date(f.lastModified());
			  Locale.setDefault(new Locale("pt", "BR"));
			return d.toString();};
		Locale.setDefault(new Locale("en", "US"));
		System.out.println(Locale.getDefault());
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o número: ");
		double numero = entrada.nextDouble();
		System.out.println(numero);
		
		File file = new File("Arquivo.txt");
		File file2 = new File("Arquivo2.txt");
		
		try {
			System.out.println("Arquivo2 criado? " + file2.createNewFile());
			System.out.println("Arquivo2 pode ser lido? " + file2.canRead());
			System.out.println("Caminho do arquivo2: " + file2.getPath());
			System.out.println("Caminho absoluto do Arquivo2: " + file2.getAbsolutePath());
			System.out.println("Arquivo2 é um diretório? " + file2.isDirectory());
			System.out.println("Arquivo2 está escondido? " + file2.isHidden());
			System.out.println("Última modificação: " + dataFormatada.apply(dateParametro, file2));
			if(file2.exists()) {
				System.out.println("Arquivo2 deletado? " + file2.delete());
			}
		}
		catch(IOException e) {
				e.printStackTrace();
		}
		
		try {
			System.out.println("Arquivo criado? " + file.createNewFile());
			System.out.println("Arquivo pode ser lido? " + file.canRead());
			System.out.println("Caminho do arquivo: " + file.getPath());
			System.out.println("Caminho absoluto do Arquivo: " + file.getAbsolutePath());
			System.out.println("Arquivo é um diretório? " + file.isDirectory());
			System.out.println("Arquivo está escondido? " + file.isHidden());
			System.out.println("Última modificação: " + dataFormatada.apply(dateParametro, file));
			if(file.exists()) {
				System.out.println("Arquivo deletado? " + file.delete());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Arquivo2 ainda existe? " + file2.exists());
		System.out.println("Arquivo ainda existe? "+ file.exists());
		entrada.close();
	}

}
