package br.com.abc.javacore.Uexpressoesregulares.test;

	public class TokensTest {
	
		public static void main(String[] args) {
			
			String str = "William, Paulo, Joana, Camila, Anna, Jhon, Matheus";
			String[] tokens = str.split("\\d");
						
			for(String arr : tokens) {
				System.out.println(arr.trim());
			}
			
		}
		
	}
