package br.com.abc.javacore.ZZMcompletablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

interface Interface{
	
}
//E sim, se declararmos que retornaremos um tipo de interface e retornarmos um objeto que implementa a interfacwe, � valido,
//e faz sentido, pois as interfaces foram criadas para burlar a falta de m�ltiplas heran�as.
class Implementadora implements Interface{
	public Interface getInterface() {
		Implementadora implementado = new Implementadora();
		return implementado;
	}
}
public class TestCompletableFuture {

	private Future<String> getString(){
		CompletableFuture<String> test = new CompletableFuture<String>();
		test.complete("Arroz + Feij�o");
		return test;
	}
}
