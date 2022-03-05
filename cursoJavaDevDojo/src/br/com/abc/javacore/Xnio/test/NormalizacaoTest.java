package br.com.abc.javacore.Xnio.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
	
	public static void main(String[] args) throws Exception {
		String diretorioProjeto = "JavaOnline\\home\\william\\dev";
		String arquivoTxt = "..\\..\\arquivo.txt";
		Path p1 = Paths.get(diretorioProjeto, arquivoTxt);
		System.out.println(p1.normalize());
		
		System.out.println();
		
		Path p2 = Paths.get("a/./b/./c");
		System.out.println(p2);
		System.out.println(p2.normalize());
		
		System.out.println();
		
		Path p3 = Paths.get("home/./william/./dev");
		Files.createDirectories(p3);
		
		Path p4 = Paths.get("pasta_pai/pasta_filho/pasta_neto");
		Files.createDirectories(p4);
		
		Path p5 = Paths.get("Pasta_base//subpasta//pasta_generica");
		Files.createDirectories(p5);
		
		Path p6 = Paths.get("Pasta_adao\\\\pasta_eva");
		Files.createDirectories(p6);
		
		Path p7 = Paths.get("Pasta_super\\.\\pasta_extendida\\.\\pasta_final");
		System.out.println(p7);
		System.out.println(p7.normalize());
		Files.createDirectories(p7);
	}

	
}
