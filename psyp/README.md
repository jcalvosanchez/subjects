# Programación de Procesos y Servicios

![Static Badge](https://img.shields.io/badge/date-2024-orange)
![Static Badge](https://img.shields.io/badge/FP-DAM2-white)
![Static Badge](https://img.shields.io/badge/asignatura-PSYP-white)
![Static Badge](https://img.shields.io/badge/java-23-blue)

Este repositorio contiene una colección de ejemplos prácticos en **Java** para demostrar conceptos explicado--s en la asignatura de **Programación de Procesos y Servicios**, en concreto sobre programación con múltiples procesos, hilos y concurrencia.

## Listado de Ejemplos

- [Multi Proceso](#multi-proceso)
  - [Ciclo de Vida de un Proceso](#ciclo-de-vida-de-un-proceso)
  - [Nuevo Proceso Java](#nuevo-proceso-java)
- [Multi Hilo](#multi-hilo)
  - [Thread Synchronization](#thread-synchronization)
  - [Thread Pools](#thread-pools)
  - [Inter-Thread Communication](#inter-thread-communication)
- [Programación Distribuida](#programación-distribuida)
  - [Hello World Server and Client]()

## Multi Proceso

En esta sección mostraremos
- Ciclo de Vida de un proceso
- Construir un proceso
- Redireccionar la salida de un proceso
- Arrancar un proceso externo a Java (ie, ping)
- Arrancar otro proceso de Java
- Mostrar la salida de un proceso en tiempo real
- Esperar a que un proceso termine

### Ciclo de Vida de un Proceso

`es.educa.psyp.multiprocess.processlifecycle.ProcessLifeCycleExample` demuestra el ciclo de vida de un proceso en Java utilizando la clase `ProcessBuilder`.

1. **Ejecutar un proceso**: Ejecutamos un proceso (por ejemplo, el comando `ping www.google.com`).
2. **Esperar a que termine**: Se espera a que el proceso finalice y se obtiene su código de salida.
3. **Manejo del código de salida**: El código de salida nos indica si el proceso se completó correctamente (código `0`) o si hubo algún error (código distinto de cero).

### Nuevo Proceso Java

`es.educa.psyp.multiprocess.processlifecycle.StartNewProcessExample` muestra cómo gestionar la ejecución de procesos en Java.

### Objetivo

El ejercicio demuestra cómo:
- Iniciar un nuevo proceso Java.
- Capturar los códigos de salida de los procesos.
- Manejar diferentes tipos de terminación de procesos (éxito, error y fallo inesperado).

#### Descripción

El código contiene una clase principal `StartNewProcessExample` con tres clases internas estáticas:
1. **`ProcessExistsOk`**: Simula un proceso que termina correctamente con código de salida `0`.
2. **`ProcessExistsKo`**: Simula un proceso que termina con código de salida `103` para representar un error.
3. **`ProcessExistsUnexpected`**: Simula un proceso que lanza una excepción, provocando un fallo inesperado.

## Multi Hilo

### Thread Synchronization
This example highlights the importance of thread synchronization to avoid race conditions when multiple threads are accessing shared resources. We cover:
- The `synchronized` keyword
- Locks and the `ReentrantLock` class
- Volatile variables and their role in thread safety

### Thread Pools
Instead of manually managing threads, Java provides thread pools to improve efficiency. In this section, we show how to:
- Use the `ExecutorService` framework to manage a pool of threads
- Submit tasks for concurrent execution
- Handle thread termination and cleanup

### Inter-Thread Communication
Communication between threads is crucial in many multithreading scenarios. In this example, we cover:
- Using `wait()` and `notify()` for basic inter-thread communication
- How to use `BlockingQueue` for producer-consumer patterns
- Best practices for managing communication between threads

## Programación Distribuida

### Hello world Server and Client

#### Descripción del problema

El objetivo es crear una aplicación que actúe a modo de **servidor**, a la espera que una aplicación **cliente** le envíe una petición (**request**) que contestará con una respuesta (**response**).

#### Solución

- **Servidor**: La clase `es.educa.psyp.distributed.sockets.HelloWorldServer` creará un `ServerSocket` para escuchar en un puerto determinado y acepta conexiones de clientes. Al recibir un mensaje, el servidor lo imprime y envía una respuesta.
- **Cliente**: El cliente `es.educa.psyp.distributed.sockets.HelloWorldClient` se conecta al servidor a través de un `Socket` y envía un mensaje. Luego, espera la respuesta del servidor e imprime el mensaje recibido.

#### Cómo ejecutarlo

El código asume que
- Servidor y cliente se ejecutan en la misma máquina.
- El puerto `12345` está libre.

Arranca el proceso del servidor. Cuando el servidor esté listo para recibir mensajes, veremos una traza en la consola:

```
Conectado al servidor en 12345
```
Arrancamos el proceso del cliente
- Intentará conectarse al servidor
- Envía una petición (request) pasando el nombre de Alicia
- Escucha la respuesta del servidor (response)
- Imprime en consola la respuesta del servidor
- Libera los recursos y se cierra

```
Conectado al servidor en localhost:12345
Respuesta del servidor: Hello Alicia, from Server!
```
En la terminal del servidor, debería mostrarse un mensaje cuando recibe el mensaje del cliente, y a continuación liberar recursos y terminar su ejecución, dejando el puerto libre.

```
Recibido del cliente: Alicia
```

#### Para saber más

##### Servidor - Puerto en uso

Si el puerto utilizado por el servidor ya está siendo utilizado por otro proceso del sistema, el servidor no podrá arrancar.

Puedes escanear los puertos que están en uso en este momento en un sistema?

##### Cliente - Servidor no encontrado

Si el cliente no puede encontrar un servidor en la dirección y puerto especificados, en este ejemplo localhost:12345, la conexión no puede realizarse.

Hay múltiples razones por las que el servidor no se encuentre
- La dirección del servidor es incorrecta
- La dirección del servidor no se puede resolver
- La dirección del servidor es correcta, pero el puerto no escucha
- El servidor no está arrancado
- El servidor está arrancado pero el proceso no
- Hay un problema de red (firewall, dns, infraestructura caída...)


## How to Run

To run the examples in this repository, you'll need to have Java 17 (or later) installed on your machine.

### Steps:
1. Clone the repository:
```bash
   git clone https://github.com/your-username/java-threads-processes.git
   cd java-threads-processes
```