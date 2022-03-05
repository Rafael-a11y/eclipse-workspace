package br.com.abc.javacore.ZZCjdbc.test;

import java.util.List;
import java.util.Scanner;

import br.com.abc.javacore.ZZCjdbc.classes.Carro;
import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CarroDAOImplNoSQL;
import br.com.abc.javacore.ZZCjdbc.interfaces.CarroDAO;

public class CarroCRUD {

private static Scanner teclado = new Scanner(System.in);
private static CarroDAO dao = new CarroDAOImplNoSQL();
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
		Carro c = new Carro();
		System.out.print("Nome: ");
		c.setNome(teclado.nextLine());
		System.out.println();
		System.out.print("PLACA: ");
		System.out.println();
		c.setPlaca(teclado.nextLine());
		System.out.println("Selecione um dos compradores abaixo: ");
		List<Comprador> compradorList = CompradorCRUD.listar();
		c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));
		dao.save(c);
	}
	
	public static void atualizar() {
		System.out.println("Selecione um dos carro abaixo: ");
		List<Carro> carroList = listar();
		Carro c = carroList.get(Integer.parseInt(teclado.nextLine().trim()));
		System.out.println("Digite um novo nome ou apenas aperte ENTER para manter o mesmo nome: ");
		String nome = teclado.nextLine();
		System.out.println("Digite uma nova PLACA ou apenas digite ENTER para manter a mesma PLACA: ");
		String placa = teclado.nextLine();
		if(!nome.isEmpty()) {
			c.setNome(nome);
		}
		if(!placa.isEmpty()) {
			c.setPlaca(placa);
		}
		dao.update(c);
	}
	
	public static List<Carro> listar() {
		Carro c;
		List<Carro> carroList = dao.selectAll();
		for(int i = 0; i < carroList.size(); i++) {
			c = carroList.get(i);
			System.out.println("índice: " + i + " { Nome: " + c.getNome() + ", PLACA: " + c.getPlaca() + ", Nome do comprador: " + c.getComprador().getNome() + " }");
		}
		return carroList;
	}
	
	public static void buscarPorNome(String nome) {
		Carro c;
		List<Carro> carroList = dao.searchByName(nome);
		for(int i = 0; i < carroList.size(); i++) {
			c = carroList.get(i);
			System.out.println("índice: " + i + " { Nome: " + c.getNome() + ", PLACA: " + c.getPlaca() + ", Nome do comprador: " + c.getComprador().getNome() + " }");
		}
	}
	
	public static void deletar() {
		System.out.println("Selecione um dos carros abaixo para deletar: ");
		List<Carro> carroList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem certeza, S/N ? ");
		String op =teclado.nextLine();
		if(op.startsWith("s")) {
			dao.delete(carroList.get(index));
		}
	}

}
