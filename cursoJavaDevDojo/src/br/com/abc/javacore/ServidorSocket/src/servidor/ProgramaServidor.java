package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProgramaServidor {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(59841);
		System.out.println("A porta 59841 foi aberta");
		System.out.println("Esperando clientes na porta 59841...");
		
		// estabelecer a conexão --> ip:porta
		Socket socket = serverSocket.accept();
		System.out.println("Cliente " + 
				socket.getInetAddress().getHostAddress() + 
				" conectado");
		
		// receber o nome -> fluxo de recebimento de dados
		DataInputStream recebimento = new DataInputStream(socket.getInputStream());
		String nome = recebimento.readUTF();
		
		// enviar o oi -> fluxo de envio de dados
		DataOutputStream envio = new DataOutputStream(socket.getOutputStream());
		envio.writeUTF("boa noite " + nome);

		System.out.println("Fechando conexão e porta");
		// fechar a conexão
		envio.close();
		recebimento.close();
		socket.close();
		serverSocket.close();
	}

}
