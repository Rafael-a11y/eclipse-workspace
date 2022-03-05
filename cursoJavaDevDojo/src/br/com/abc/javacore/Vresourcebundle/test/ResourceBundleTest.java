package br.com.abc.javacore.Vresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en","US"));
		System.out.println(Locale.getDefault());
		ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en","US"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("good.morning"));
		System.out.println(rb.getString("show"));
		rb = ResourceBundle.getBundle("messages", new Locale("pt","BR"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("good.morning"));
		System.out.println(rb.getString("show")); 
		ResourceBundle file = ResourceBundle.getBundle("C:\\USERS\\MASTER\\eclipse-workspace\\cursoJavaDevDojo\\Teste.txt", new Locale("pt", "BR"));
		System.out.println(file.getString("alfabeto"));
		
		/*Locale locale = new Locale("fr","CA");
		 * ResourceBundle.getBundle("messages", locale);
		 * messages_fr_CA.properties
		 * messages_fr.properties
		 * messages_en_US.properties
		 * messages_en.properties
		 * messages.properties
		 * Se nenhuma das anteriores der certo, uma exception � lan�ada*/
		
	}

}