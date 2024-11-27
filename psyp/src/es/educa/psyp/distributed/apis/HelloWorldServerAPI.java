package es.educa.psyp.distributed.apis;

public interface HelloWorldServerAPI {

	// Puerto en el que el servidor escuchará
	int getServerPort();

	// Método que retorna un saludo personalizado con el nombre dado
	String helloName (String name);

}
