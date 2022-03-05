package BlocoNotas;

public class Nota {
    String texto;
    
    public Nota(){}
    
    public Nota(String texto) {
        this.texto = texto;
    }
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    @Override
    public String toString(){
    	return " nota { " + this.texto  + " }";
    }
}
