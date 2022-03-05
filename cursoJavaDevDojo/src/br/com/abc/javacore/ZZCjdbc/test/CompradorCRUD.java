package br.com.abc.javacore.ZZCjdbc.test;

import java.util.List;
import java.util.Scanner;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDAOImpl;

public class CompradorCRUD {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void executar(int op) {
		switch(op) {
		case 1 : inserir(); break;
		case 2: atualizar();break;
		case 3 : listar();  break;
		case 4: {
			System.out.println("Entre com o nome: ");
			buscarPorNome(teclado.nextLine());
			break;
		}
		case 5 : deletar(); break;
		}
	}

	public static void inserir() {
		Comprador c = new Comprador();
		System.out.print("Nome: ");
		c.setNome(teclado.nextLine());
		System.out.println();
		System.out.print("CPF: ");
		System.out.println();
		c.setCpf(teclado.nextLine());
		CompradorDAOImpl.save(c);
	}
	
	public static void atualizar() {
		System.out.println("Selecione um dos compradores abaixo: ");
		List<Comprador> compradorList = listar();
		Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine().trim()));
		System.out.println("Digite um novo nome ou apenas aperte ENTER para manter o mesmo nome: ");
		String nome = teclado.nextLine();
		System.out.println("Digite um novo CPF ou apenas digite ENTER para manter o mesmo CPF: ");
		String cpf = teclado.nextLine();
		if(!nome.isEmpty()) {
			c.setNome(nome);
		}
		if(!cpf.isEmpty()) {
			c.setCpf(cpf);
		}
		CompradorDAOImpl.update(c);
	}
	
	public static List<Comprador> listar() {
		Comprador c;
		List<Comprador> compradorList = CompradorDAOImpl.selectAll();
		for(int i = 0; i < compradorList.size(); i++) {
			c = compradorList.get(i);
			System.out.println("índice: " + i + " { Nome: " + c.getNome() + ", CPF: " + c.getCpf() + " }");
		}
		return compradorList;
	}
	
	public static void buscarPorNome(String nome) {
		Comprador c;
		List<Comprador> compradorList = CompradorDAOImpl.searchByName(nome);
		for(int i = 0; i < compradorList.size(); i++) {
			c = compradorList.get(i);
			System.out.println("índice: " + i + " { Nome: " + c.getNome() + ", CPF: " + c.getCpf() + " }");
		}
	}
	
	public static void deletar() {
		System.out.println("Selecione um dos compradores abaixo para deletar: ");
		List<Comprador> compradorList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem certeza, S/N ? ");
		String op =teclado.nextLine();
		if(op.startsWith("s")) {
			CompradorDAOImpl.delete(compradorList.get(index));
		}
	}

}
