package br.com.abc.javacore.Zcolecoes.classes;

import java.util.Comparator;

public class Celular {

	private String nome;
	private String IMEI;
	
	public Celular(String nome, String IMEI) {
		this.nome = nome;
		this.IMEI = IMEI;
	}
	
	/*Reflexivo -> x.equals(x) tem que ser true para tudo que for diferente de null;
	 *Sim�trico -> para x e y diferentes de null, se x.equals(y) = true, logo, y.equals(x) deve ser true;
	 *Transitividade -> para x, y, e z diferentes de null, se x.equals(y) == true e o contr�rio tamb�m � true, e x.equals(z)
	 *		== true, logo y.equals(z) tamb�m deve ser true;
	 *Consistente -> x.equals(y) deve retornar o mesmo valor sempre, e para x != null e x.equals(null) deve ser false;*/
	
	/*Para hashCode
	 * Se x.equals(y) == true, y.hashCode() == x.hashCode().
	 * Se y.hashCode() == x.hashCode(), n�o necesssariamente o equals dever� retornar true.
	 * Se x.equals(y) for falso, voc� n�o precisa ter hashCODE(), retorne false.
	 * Se y.hashCode() != x.hashCode(), x.equals(y) == false*/
	
	@Override
	
	public int hashCode() {
		return IMEI != null ? IMEI.hashCode() : 1;
	}
	@Override
	public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Celular outroCelular = (Celular) obj;
        return IMEI != null && IMEI.equals(outroCelular.getIMEI());

    }
	
	
	
	@Override
	public String toString() {
		return "Celular { nome = " + nome + ", IMEI = " + IMEI + "}";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
}
