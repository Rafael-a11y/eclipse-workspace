package programacaoOOEmJava.OO;
import java.util.Comparator;
/*Implementar um algorítmo que determine e escreva a maior idade dos habitantes ;
 *  
 *porcentagem de indivíduos do sexo feminino cuja idade esteja entre 18 e 35 anos, inclusive, e que tenham
 *os olhos verdes e cabelos louros*/
import java.util.List;
import java.util.stream.Collectors;

public class Programinha2Test {

	public static void main(String[] args) {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		System.out.println("Idade mais alta da lista: " + pessoas.stream().max(Comparator.comparing(Pessoa::getIdade))
				.map(Pessoa::getIdade).get());
		
		
		long numDePessoasDoSexoFeminino = pessoas.stream().filter(p -> p.getSexo() == Sexo.FEMININO).
				filter(p -> p.getIdade() > 18 && p.getIdade() < 35).filter
				(p -> p.getCorDosOlhos() == CorDosOlhos.VERDE && p.getCorDosCabelos() == CorDosCabelos.LOURO).count();
				
				
		double result = (double) numDePessoasDoSexoFeminino /(pessoas.stream().count());
		System.out.println("Porcentagem de indivíduos do sexo feminino cuja idade está entre 18 e 35 anos, \n"
				+ "que possuam os olhos verdes e cabelos loiros " + result +  "%");
		
		
	}

}
