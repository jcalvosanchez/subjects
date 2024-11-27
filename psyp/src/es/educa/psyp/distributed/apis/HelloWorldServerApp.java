package es.educa.psyp.distributed.apis;

import java.io.*;
import java.net.*;

public class HelloWorldServerApp {

	public static void main(String[] args) {
		try {
			// Crear un servidor en el puerto especificado
			HelloWorldServerAPI helloWorldServer = new HelloWorldServer();
			ServerSocket servidor = new ServerSocket(helloWorldServer.getServerPort());
			System.out.println("Servidor iniciado. Esperando conexiones...");

			// Aceptar conexiones de clientes
			while (true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado desde: " + cliente.getInetAddress().getHostAddress());

				// Crear flujos de entrada y salida
				BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

				// Leer la petición del cliente
				String message = entrada.readLine();
				if (message != null) {
					System.out.println("Recibido del cliente: " + message);
					String respuesta = helloWorldServer.helloName(message);
					// Procesar la solicitud y ejecutar el método correspondiente
					salida.println(respuesta);
				}

				// Cerrar los recursos
				cliente.close();
				entrada.close();
				salida.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
