package es.educa.psyp.multiprocess.startNewProcess;

import es.educa.psyp.multiprocess.utils.ProcessUtils;

import java.io.IOException;

public class StartNewProcessExample {

	public static final String PROCESS_PACKAGENAME = "es.educa.psyp.multiprocess.startNewProcess.";

	public static class ProcessExistsOk {
		public static void main(String[] args) {
			System.out.println("ProcessExistsOk start");
			System.out.println("ProcessExistsOk end");
		}
	}
	public static class ProcessExistsKo {
		public static void main(String[] args) {
			System.out.println("ProcessExistsKo start");
			System.out.println("ProcessExistsKo end");
			System.exit(103);
		}
	}
	public static class ProcessExistsUnexpected {
		public static void main(String[] args) {
			System.out.println("ProcessExistsUnexpected start");
			throw new RuntimeException("Unexpected exist");
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Primary Process start");

		Process okProcess = startProcessUsingProcessBuilder("StartNewProcessExample$ProcessExistsOk");
		System.out.println("ProcessExistsOk - Código de salida del proceso: " + okProcess.waitFor());

		Process koProcess = startProcessUsingProcessBuilder("StartNewProcessExample$ProcessExistsKo");
		System.out.println("ProcessExistsKo - Código de salida del proceso: " + koProcess.waitFor());

		Process unexpectedExitProcess = startProcessUsingProcessBuilder("StartNewProcessExample$ProcessExistsUnexpected");
		System.out.println("ProcessExistsUnexpected - Código de salida del proceso: " + unexpectedExitProcess.waitFor());

		System.out.println("Primary Process end");
	}

	private static Process startProcessUsingProcessBuilder(String className) throws IOException {
		ProcessBuilder pb = ProcessUtils.buildProcess("java", "-cp", "./out/production/psyp", PROCESS_PACKAGENAME + className);
//		pb.directory(new File(PROCESS_WORKING_DIRECTORY));
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
//		pb.redirectError(ProcessBuilder.Redirect.INHERIT);

		return ProcessUtils.runProcess(pb);
	}
}
