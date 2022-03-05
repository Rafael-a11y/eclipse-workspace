package swing.provaav1;

public class Carro implements Comparable<Carro>{

	private Integer id;
	private String placa;
	private String marca;
	private String modelo;
	private Integer potenciaEmCavalos;
	
	public Carro(String modelo, int potencia) {
		this.setModelo(modelo);
		this.setPotenciaEmCavalos(potencia);
	}
	public Carro() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getPotenciaEmCavalos() {
		return potenciaEmCavalos;
	}
	public void setPotenciaEmCavalos(Integer potenciaEmCavalos) {
		this.potenciaEmCavalos = potenciaEmCavalos;
	}
	@Override
	public int compareTo(Carro outroCarro) {
		if (outroCarro == null || outroCarro.getPotenciaEmCavalos() == null) {
			return 1;
		} else if (this.getPotenciaEmCavalos() == null) {
			return -1;
		} else {
			return this.getPotenciaEmCavalos().compareTo(outroCarro.getPotenciaEmCavalos());
		}
	}
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", potenciaEmCavalos=" + potenciaEmCavalos + "]";
	}

}
