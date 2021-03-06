package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class AcharTodosOsBkps extends SimpleFileVisitor<Path>{
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//		if(file.getFileName().toString().endsWith(".bkp")){
			System.out.println(file.getFileName());
//	}
		return FileVisitResult.CONTINUE;
	}
}

public class FileVisitorTest {

	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("pasta/subpasta"), new PrintDirs ());
		
	}

}

class PrintDirs extends SimpleFileVisitor<Path>{

	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if(dir.getFileName().toString().equals("subsubpasta3")) {
			return FileVisitResult.SKIP_SIBLINGS;
		}
		System.out.println("pre: " + dir);
		return FileVisitResult.CONTINUE;
		
	}
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file " + file.getFileName());
		return FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exe) throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitDirectory(Path dir, IOException exe) {
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
		
	}
}
