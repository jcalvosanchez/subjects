package es.educa.psyp.distributed.sockets;

import java.io.*;
import java.net.*;

public class HelloWorldServer {
	private static final int SERVER_PORT = 12345; // Puerto en el que el servidor escuchará

	/**
	 * Creación de un servidor que escuchará en el puerto SERVER_PORT. Espera un nombre y responderá con un mensaje de hello world con el nombre recibido
	 * @param args
	 */
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
			System.out.println("Servidor escuchando en el puerto " + SERVER_PORT);

			// Esperar y aceptar la conexión del cliente
			Socket clientSocket = serverSocket.accept();
			System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

			// Flujos de entrada y salida para la comunicación con el cliente
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			// Leer el mensaje del cliente
			String message = in.readLine();
			System.out.println("Recibido del cliente: " + message);

			// Enviar respuesta al cliente
			out.println("Hello " + message + ", from Server!");

			// Cerrar conexiones
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
