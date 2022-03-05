package br.com.abc.javacore.Yserializacao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.abc.javacore.Yserializacao.classes.Aluno;
import br.com.abc.javacore.Yserializacao.classes.Turma;

public class SerializacaoTest {

	public static void main(String[] args) {
		gravadorObjeto();
		leitorObjeto();
	}
	
	private static void gravadorObjeto() {
		Turma t = new Turma("Maraona Java s� para os campe�es");
		Aluno aluno = new Aluno(1L, "William Suane", "123456");
		aluno.setTurma(t);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))){
			oos.writeObject(aluno);
			oos.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void leitorObjeto() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))){
			Aluno aluno = (Aluno) ois.readObject();
			System.out.println(aluno);
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
