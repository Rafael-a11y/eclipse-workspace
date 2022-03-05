package padroes.observer;

public class FestaSurpresa {
	public static void main(String[] args) {
		Porteiro porteiro = new Porteiro();
//		Namorada namorada = new Namorada();
		porteiro.registrarObservador(new ObservadorChegadaAniversariante() {
			
			public void chegou(EventoChegadaAniversariante e) {
				System.out.println("Surpresa via classe anônima");
			}
		});
		porteiro.registrarObservador(e -> {System.out.println("Surpresa via lambda");
		System.out.println("Aconteceu em " + e.getMomento());});
		porteiro.monitorar();
	}
}
