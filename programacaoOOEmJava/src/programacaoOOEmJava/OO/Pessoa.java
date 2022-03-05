package programacaoOOEmJava.OO;

import java.util.Arrays;
import java.util.List;

/*Uma pesquisa sobre algumas características físicas da população de uma determinada região coletou os seguintes dados,
 * referentes a cada habitante, para serem analisados:
 * a	sexo(masculino, feminino)
 * b	cor dos olhos(azul, verde, castanho)
 * c	cor dos cabelos(louros, castanhos, pretos)
 * d	idade em anos
 * e	Para cada habitante é feito um cadastro com esses dados, e o último cadastro, que não corresponde a ninguem,
 * 		conterá o valor da idade igual à -1.
 * 
 *Implementar um algorítmo que determine e escreva a maior idade dos habitantes ; porcentagem de indivíduos do sexo feminino
 *cuja idade esteja entre 18 e 35 anos, inclusive, e que tenham os olhos verdes e cabelos louros*/
public class Pessoa {

	private Sexo sexo;
	private CorDosOlhos corDosOlhos;
	private CorDosCabelos corDosCabelos;
	private int idade;
	
	public Pessoa(Sexo sexo, CorDosOlhos corDosOlhos, CorDosCabelos corDosCabelos, int idade) {
		this.sexo = sexo;
		this.corDosOlhos = corDosOlhos;
		this.corDosCabelos = corDosCabelos;
		this.idade = idade;
	}
	
	public static List<Pessoa> bancoDePessoas(){
		return Arrays.asList(new Pessoa(Sexo.MASCULINO, CorDosOlhos.AZUL, CorDosCabelos.LOURO, 18),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.VERDE, CorDosCabelos.CASTANHO, 19),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.CASTANHO, CorDosCabelos.PRETO, 20),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.AZUL, CorDosCabelos.CASTANHO, 21),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.AZUL, CorDosCabelos.LOURO, 22),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.VERDE, CorDosCabelos.CASTANHO, 23),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.CASTANHO, CorDosCabelos.PRETO, 24),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.VERDE, CorDosCabelos.CASTANHO, 25),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.CASTANHO, CorDosCabelos.PRETO, 26),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.VERDE, CorDosCabelos.CASTANHO, 27),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.CASTANHO, CorDosCabelos.PRETO, 28),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.CASTANHO, CorDosCabelos.PRETO, 29),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.AZUL, CorDosCabelos.CASTANHO, 30),
			new Pessoa(Sexo.MASCULINO, CorDosOlhos.AZUL, CorDosCabelos.LOURO, 31),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.VERDE, CorDosCabelos.LOURO, 32),
			new Pessoa(Sexo.FEMININO, CorDosOlhos.CASTANHO, CorDosCabelos.CASTANHO, 33));
	}
	
	@Override
	public String toString() {
		return "Pessoa { sexo = " + sexo + ", corDosOlhos = " + corDosOlhos + ", corDosCabelos = " + corDosCabelos + ", idade = "
				+ idade + " }";
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public CorDosOlhos getCorDosOlhos() {
		return corDosOlhos;
	}
	public void setCorDosOlhos(CorDosOlhos corDosOlhos) {
		this.corDosOlhos = corDosOlhos;
	}
	public CorDosCabelos getCorDosCabelos() {
		return corDosCabelos;
	}
	public void setCorDosCabelos(CorDosCabelos corDosCabelos) {
		this.corDosCabelos = corDosCabelos;
	}
	public Integer getIdade() {
		Integer nIdade;
		return nIdade = (Integer) idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
