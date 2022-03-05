package br.com.abc.javacore.Wio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDiretorioTest {

	public static void main(String[] args) throws IOException {
		
//		String currentDirectory = System.getProperty("user.dir");
//		System.out.println("The current working directory is " + currentDirectory);
		
//		File diretorio = new File("Folder");
//		boolean mkdir = diretorio.mkdir();
//		System.out.println("Diretório criado? " + mkdir);
//		
//		File arquivo = new File(diretorio, "arquivo.txt");
//		boolean newFile = arquivo.createNewFile();
//		System.out.println("ASrquivo criado? " + newFile);
//		
//		File arquivoNovoNome = new File("arquivo_renomeado.txt");
//		System.out.println("Arquivo criado? " + arquivoNovoNome.exists() + " " + arquivoNovoNome.getAbsolutePath());
//		boolean renamed = arquivo.renameTo(arquivoNovoNome);
//		System.out.println("Arquivo renomeado? " + renamed);
//		
//		File diretorioRenomeado = new File("Folder2");
//		boolean diretorioRenamed = diretorio.renameTo(diretorioRenomeado);
//		System.out.println("Diretório renomeado? " + diretorioRenamed);
		buscarArquivos();
		/*Forma mais difícil de criar arquivo já no caminho do bem.*/
//		File arquivo = new File("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\Folder\\FileDiretorioTest.txt");
//		boolean newFile = arquivo.createNewFile();
//		if(newFile) {
//			System.out.println("Arquivo criado com suscesso -> " + arquivo.getAbsolutePath());
//		}
		
	}
	public static void buscarArquivos() {
		File file = new File("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo");
		String[] list = file.list();
		for(String arquivo : list) {
			System.out.println(arquivo);
		}
	}

}
