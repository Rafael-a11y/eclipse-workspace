package br.com.abc.javacore.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {

	public static void main(String[] args) throws Exception{
		
//		Path p1 = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\Arquivo.txt");
//		Path p2 = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo", "Arquivo.txt");
//		Path p3 = Paths.get("C:", "Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo","Arquivo.txt");
//		Path p4 = Paths.get("C:", "Users", "MASTER", "eclipse-workspace", "cursoJavaDevDojo", "Arquivo.txt");
//		Path p5 = Paths.get("C:", "Users", "MASTER", "eclipse-workspace", "cursoJavaDevDojo", "ArquivoPath.txt");
//		System.out.println(p4.toAbsolutePath());
//		File file = p4.toFile();
//		Path path = file.toPath();
//		
//		Path path1 = Paths.get("pasta");
//		Path path2 = Paths.get("pasta\\subPasta\\subSubPasta\\file.txt");
//		Path arquivo = Paths.get("pasta\\subPasta\\subSubPasta\\file.txt");
//		
//		try {
////			if(Files.notExists(path1)) {
////				Files.createDirectories(path1);
//			if(Files.notExists(path2.getParent())) {
//				Files.createDirectories(path2.getParent());
//				Files.createFile(arquivo);
//			}
//			if(Files.notExists(arquivo)) {
//				Files.createFile(arquivo);
//			}
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Path source = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\Folder2\\arquivo.txt");
//		Path target = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\Folder2\\arquivo_renomeado.txt");
//		try {
//			Files.createFile(source);
//			Files.createFile(target);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			Files.copy(source, target);
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		Path caminho1 = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\pasta");
//		Path caminho2 = Paths.get("C:\\Users\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\pasta");
		if(Files.notExists(caminho1)) //&& Files.notExists(caminho2))
		Files.createDirectories(caminho1);
//		Files.createDirectories(caminho2);
		
		
		Path source = Paths.get(caminho1.toString(), "arquivo_fonte.txt");
		Path target = Paths.get(caminho1.toString(), "arquivo_destino.txt");
		
		if(Files.notExists(source) && Files.notExists(target)) {
			Files.createFile(source);
			Files.createFile(target);
		}
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		Files.deleteIfExists(target);
		
	}
}
