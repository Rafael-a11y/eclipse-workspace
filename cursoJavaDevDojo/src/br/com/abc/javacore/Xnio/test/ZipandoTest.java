package br.com.abc.javacore.Xnio.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {

	public static void main(String[] args) {
		
		/*Este � o caminho para onde ser� salvo o arquivo.zip, lembre-se, o caminho n�o come�a com /, estamos trabalhando com
		 * o caminho relativo. Isso significa que dentro da pasta do meu projeto existe o diret�rio de sele��o/subpasta
		 * ex: C:/ MeuProjetoJava/pasta/subpasta.
		 * N�o ficar� final C:/MeuProjetoJava/pasta/subpasta/arquivo.zip */
		Path dirZip = Paths.get("pasta/subpasta");
		 /*Dentro deste diret�rio est�o todos os arquivos que queremos zipar. Vamos zipar todos os arquivos que compensam no
		  * diret�rio C:/MeuProjetoJava/pasta/subpasta/subsubpasta*/
		Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
		/*O reolve vai juntar o primeiro caminho: pasta/subpasta com o arquivo.zip	e usaremos uma vari�vel de ref�ncia
		 * zipFile para referenciar para criar o arquivo.zip dentro do diret�rio pasta/subpasta.*/
		Path zipFile = dirZip.resolve("arquivo.zip");
		/*Ao ser relacionado, esse try-with-resources vai criar o arquivo.zip automaticamente.*/
		try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
				/*Como iremos zipar todos os arquivos do diret�rio dirFiles, apenas iteramos sobre eles usando DirectoryStream.*/
				DirectoryStream<Path> streams = Files.newDirectoryStream(dirFiles);){
			/*Files.newDirectoryStream() pede como par�metro o diret�rio que possui os arquivos a serem zipados.
			 * Lembrando que os declarei dentro de um Try With Resources para n�o ter que me preocupar em fechar os canais.*/
			for(Path path : streams) {
				/*Adicionamos ao arquivo.zip uma entrada zipEntry, que � o  arquivo a ser copiado dentro do zip*/
				zip.putNextEntry(new ZipEntry(path.getFileName().toString()));
				/*O c�digo abaixo copiar� os dados do arquivo para o arquivo dentro do zip.*/
				BufferedInputStream bf = new BufferedInputStream(new FileInputStream(path.toFile()));
				byte[] buff = new byte[2048];
				int bytesRead;
				while((bytesRead = bf.read(buff)) > 0) {
					zip.write(buff, 0, bytesRead);
				}
				zip.flush();
				zip.closeEntry();
				bf.close();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
