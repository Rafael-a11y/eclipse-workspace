package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPaths {

	public static void main(String[] args) throws IOException {
		
		Path dir = Paths.get("home\\william");
		Path arquivo = Paths.get("dev//arquivo.txt");
		Path result = dir.resolve(arquivo);
		System.out.println(result);
//		Files.createDirectories(dir.resolve(arquivo).getParent());
		
		Path absoluto = Paths.get("/home/william");
		Path relativo = Paths.get("dev");
		Path file = Paths.get("file.txt");
		Path pasta = Paths.get("/pasta/subpasta/subsubpasta");
		Path subPasta = Paths.get("subpasta/subsubpasta");
		System.out.println("0: " + pasta.resolve(subPasta));
		
		System.out.println("1: " + absoluto.resolve(relativo));
		System.out.println("2: " + absoluto.resolve(file));
		System.out.println("3: " + relativo.resolve(file));
		System.out.println("4: " + relativo.resolve(absoluto));
		System.out.println("5: " + file.resolve(absoluto));
		System.out.println("6: " + file.resolve(relativo));
	}

}
