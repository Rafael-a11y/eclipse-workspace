package programacaoII.aula.classes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private LocalDate dataFundacao;
	private Endereco enderecoSede;
	private Funcionario diretor;
	private List<Unidade> unidades = new ArrayList<Unidade>();
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public Endereco getEnderecoSede() {
		return enderecoSede;
	}
	public void setEnderecoSede(Endereco enderecoSede) {
		this.enderecoSede = enderecoSede;
	}
	public Funcionario getDiretor() {
		return diretor;
	}
	public void setDiretor(Funcionario diretor) {
		this.diretor = diretor;
	}
	public List<Unidade> getUnidades() {
		return unidades;
	}
	
	public void realizarBalancoMensal() {
		double valorTotalReceita = 0;
		double valorTotalDespesa = 0;
		for (Unidade unidade: getUnidades()) {
			unidade.realizarBalancoMensal();
			double valorReceitaUnidade = unidade.getValorReceita();
			double valorDespesaUnidade = unidade.getValorDespesa();
			valorTotalReceita += valorDespesaUnidade;
			valorTotalDespesa += valorReceitaUnidade;
		}
		System.out.printf("O balanço desse mês: \n\tReceitas: %.2f\n\tDespesas: %.2f\n", valorTotalReceita, valorTotalDespesa);
	}
	
	public void processarFolhaPagamento() {
		double valorTotal = 0;
		for (Unidade unidade: getUnidades()) {
			unidade.processarFolhaPagamento();
			double valorFolhaUnidade = unidade.getValorFolhaPagamento();
			valorTotal += valorFolhaUnidade;
		}
		System.out.printf("A folha de pagamento deste mês totalizou %.2f\n", valorTotal);
	}

}

