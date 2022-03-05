package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

public class Aluno {
			
		final String  nome;
		 double nota1;
		 double nota2;
		 double nota3;
		
		public Aluno(String nome, double nota1, double nota2, double nota3){
			this.nome = nome;
			this.nota1 = nota1;
			this.nota2 = nota2;
			this.nota3 = nota3;
		}
		List<String> diciplinas = Arrays.asList("Programação1");
		
		static Function<Aluno, Double> verificacaoAv1 = a -> {
			double resultado = (a.nota1 < 4) ? a.nota1 = 0.0 :  a.nota1;
			return resultado;
		};
		static Function<Aluno,Double> verificacaoAv2 = a -> {double resultado = 
				a.nota2 < 4 ? a.nota2 = 0.0 : a.nota2;
				return resultado;
		};
		static Function<Aluno,Double> verificacaoAv3 = a -> {double resultado = 
			a.nota3 < 4 ? a.nota3 = 0.0 : a.nota3;
			return resultado;};
			
		static Function<Aluno,Double> maiorNota = a -> { 
			if(a.nota1 > a.nota2) {
				return a.nota1;
			}
			else if(a.nota2 > a.nota1) {
				return a.nota2;
			}
			return a.nota1;};
			
		static Predicate<Aluno> notasBoa = a -> a.nota1 >= 6;
		
		static Function<Aluno, String> saudacaoAprovado = a -> "Parabéns " +
				a.nome + "! Você foi aprovado(a)!";
		public Aluno(String nome, double nota1) {
			this.nome = nome;
			this.nota1 = nota1;
		}
		public String toString() {
			return this.nome + " tem nota " + this.nota1;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((diciplinas == null) ? 0 : diciplinas.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			long temp;
			temp = Double.doubleToLongBits(nota1);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(nota2);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(nota3);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aluno other = (Aluno) obj;
			if (diciplinas == null) {
				if (other.diciplinas != null)
					return false;
			} else if (!diciplinas.equals(other.diciplinas))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (Double.doubleToLongBits(nota1) != Double.doubleToLongBits(other.nota1))
				return false;
			if (Double.doubleToLongBits(nota2) != Double.doubleToLongBits(other.nota2))
				return false;
			if (Double.doubleToLongBits(nota3) != Double.doubleToLongBits(other.nota3))
				return false;
			return true;
		}
		
	}
