package es.educa.psyp.multiprocess.processlifecycle;

import static es.educa.psyp.multiprocess.utils.ProcessUtils.*;

/**
 * Clase que demuestra el ciclo de vida de un proceso en Java utilizando ProcessBuilder.
 * </p>
 * 1. **Ejecución del Proceso**:
 *    El proceso se ejecuta (en este caso, `ping google.com`)..
 * 2. **Esperar la Terminación**:
 *    El proceso espera a que termine y luego se obtiene el código de salida.
 * 3. **Manejo del Código de Salida**:
 *    Se verifica el código de salida del proceso para determinar si se ejecutó correctamente
 *    o si hubo algún error.
 */
public class ProcessLifeCycleExample {

	public static void main(String[] args) throws Exception {
		String[] command = getPingGoogleCommand();

		Process process = executeCommand(command);

		// Wait for the process to finish and get the exit code
		int exitCode = process.waitFor();
		manageExternalProcessExitCode(exitCode);
	}

}
