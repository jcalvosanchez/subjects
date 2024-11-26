package es.educa.psyp.distributed.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloWorldClient {
	private static final String SERVER_ADDRESS = "localhost";
	private static final int SERVER_PORT = 12345;

	public static void main(String[] args) {
		try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
			System.out.println("Conectado al servidor en " + SERVER_ADDRESS + ":" + SERVER_PORT);

			// Flujos de entrada y salida para la comunicación con el servidor
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// Enviar mensaje al servidor
			out.println("Alicia");

			// Leer respuesta del servidor
			String response = in.readLine();
			System.out.println("Respuesta del servidor: " + response);

			// Cerrar conexiones
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
