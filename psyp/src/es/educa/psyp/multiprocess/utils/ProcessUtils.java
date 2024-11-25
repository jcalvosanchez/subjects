package es.educa.psyp.multiprocess.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUtils {

	// Equivalent to buildProcess and runProcess
	public static Process executeCommand(String... command) throws IOException {
		return Runtime.getRuntime().exec(command);
	}

	// Build offers more flexibility and simplicity, such as redirecting output and error flows
	public static ProcessBuilder buildProcess(String... command) {
		return new ProcessBuilder(command);
	}

	public static Process runProcess(ProcessBuilder processBuilder) throws IOException {
		return processBuilder.start();
	}

	public static void realTimeReadProcessOutPut(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void manageExternalProcessExitCode(int exitCode) {
		System.out.println("Código de salida del proceso: " + exitCode);
		if (exitCode == 0) {
			System.out.println("El proceso se ejecutó correctamente.");
		} else {
			System.out.println("Hubo un error al ejecutar el proceso.");
		}
	}

	// Ejemplo de comando para ejecutar 'ping' a google.com
	public static String[] getPingGoogleCommand() {
		String[] command = {"ping", "google.com"};
		return command;
	}
}
