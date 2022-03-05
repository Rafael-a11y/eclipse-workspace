package br.com.abc.javacore.Xnio.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {

	public static void main(String[] args) throws Exception {
		
		String currentDirectory = System.getProperty("user.dir");
		System.out.println("Diretório atual é: " + currentDirectory);
		
		Path dir = Paths.get("/home/william");
		Path classe = Paths.get("/home/william/java/Pessoa.java");
		Path pathToClasse = classe.relativize(dir);
		System.out.println(pathToClasse);
		
		Path absoluto1 = Paths.get("/home/william");
		Path absoluto2 = Paths.get("/usr/local");
		Path absoluto3 = Paths.get("/home/william/java/Pessoa.java");
		Path relativo1 = Paths.get("temp");
		Path relativo2 = Paths.get("temp/Funcionario.java");
		
		System.out.println("1: " + absoluto1.relativize(absoluto3));
		System.out.println("2: " + absoluto3.relativize(absoluto1));
		System.out.println("3: " + absoluto1.relativize(absoluto2));
		System.out.println("4: " + relativo1.relativize(relativo2));
//		System.out.println("5: " + absoluto1.relativize(relativo1));
		
//		Files.createDirectories(absoluto1.relativize(absoluto3));
//		Path ab1ComAb3 = Files.createDirectories(absoluto1.relativize(absoluto3));
//		System.out.println(Files.exists(ab1ComAb3));
//		if(Files.exists(ab1ComAb3)) {
//			System.out.println(ab1ComAb3.toAbsolutePath());
//		}
		
//		Path ab1ComAb2 = Files.createDirectories(absoluto1.relativize(absoluto2));
//		boolean ab1ComAb2Existe = Files.exists(ab1ComAb2 );
//		if(ab1ComAb2Existe) {
//			System.out.println(ab1ComAb2 .toAbsolutePath());
//		}
		
//		Path re1ComRe2 = Files.createDirectories(relativo1.relativize(relativo2));
//		boolean re1ComRe2Existe = Files.exists(re1ComRe2);
//		if(re1ComRe2Existe) {
//			System.out.println(re1ComRe2.toAbsolutePath());
//		}
		
		
	}

}
