package excecao;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

public class Aluno {
			
		 private final  String  nome;
		 private double nota;
		 private boolean bomComportamento;
		
		public Aluno(String nome, double nota){
			this(nome, nota, true);
		}
		private List<String> diciplinas = Arrays.asList("Programação1");
		
		public Aluno(String nome, double nota, boolean bomComportamento) {
			this.nome = nome;
			this.nota = nota;
			this.bomComportamento = bomComportamento;
		}
		public String toString() {
			return this.nome + " tem nota " + this.nota;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (bomComportamento ? 1231 : 1237);
			result = prime * result + ((diciplinas == null) ? 0 : diciplinas.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			long temp;
			temp = Double.doubleToLongBits(nota);
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
			if (bomComportamento != other.bomComportamento)
				return false;
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
			if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
				return false;
			return true;
		}
		public double getNota() {
			return nota;
		}
		public void setNota(double nota) {
			this.nota = nota;
		}
		public boolean isBomComportamento() {
			return bomComportamento;
		}
		public void setBomComportamento(boolean bomComportamento) {
			this.bomComportamento = bomComportamento;
		}
		public List<String> getDiciplinas() {
			return diciplinas;
		}
		public void setDiciplinas(List<String> diciplinas) {
			this.diciplinas = diciplinas;
		}
		public String getNome() {
			return nome;
		}
		
		
		
		
	}
