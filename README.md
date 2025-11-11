TPO Final - eScrims: Plataforma de eSports
Este proyecto es el Trabajo Práctico Final para la materia Proceso de Desarrollo de Software.

Información del Grupo

Universidad: UADE - Facultad de Ingeniería y Ciencias Exactas 


Materia: Proceso de Desarrollo de Software 


Docente: Ruiz Matias 


Grupo 6: 

Acuña Laura (1177259) 


Alves Juan (1142620) 


Bossio Manuel (1191114) 

Cuenca Marcos (1185654) 

Molina Lautaro (1174643) 

Nieva Rodrigo (1108233) 


1. Propósito del Proyecto
El objetivo de este TPO es diseñar y desarrollar (ADOO) el backend de una plataforma para organizar scrims (partidas amistosas) de eSports.

El sistema gestiona el ciclo de vida completo de una partida, desde su creación y emparejamiento hasta su finalización y notificación a los jugadores, aplicando los principios SOLID y los patrones de diseño vistos en la materia.

2. Arquitectura
El código fuente cumple con la arquitectura de 4 capas solicitada en la consigna:

Controller: Simulado por main.controller.ConsoleController. Actúa como la "View" o "App móvil", según lo validado con el docente.

Service: Contiene la lógica de negocio y coordinación, por ejemplo, main.service.ScrimService.

Domain: El núcleo del sistema. Contiene las entidades (Scrim, Usuario) y las implementaciones de los patrones de dominio (State, Strategy, etc.).

Infra: Representa los servicios externos.

Persistencia: Simulada con main.repo.InMemoryScrimRepo (cumpliendo con la consigna de no requerir una BBDD real).

Notificaciones: El paquete main.infra.notificacion contiene los Adapters y Factories.

3. Patrones de Diseño Implementados
Este proyecto implementa 7 patrones de diseño (los 4 obligatorios y 3 opcionales):

Patrones Obligatorios

State: Utilizado para gestionar el ciclo de vida completo del Scrim (documentado en CUs 4 al 9 ).

Clases: ScrimState, ScrimContext, StateBuscando, StateLobbyArmado, StateConfirmado, StateEnJuego, StateFinalizado, StateCancelado.


Strategy: Utilizado para definir algoritmos intercambiables de emparejamiento (CU5) .

Clases: MatchmakingStrategy, ByMMRStrategy, ByLatencyStrategy, ByHistoryStrategy.


Observer: Utilizado para notificar cambios de estado (CU10)  de forma desacoplada.

Clases: DomainEventBus (Subject), Subscriber (Observer), ScrimStateChanged (Event).

Abstract Factory: Utilizado para crear familias de notificadores (simulados vs. reales) sin acoplar el Controller.

Clases: NotifierFactory, DevNotifierFactory, ProdNotifierFactory.

Patrones Opcionales

Builder: Utilizado para la creación compleja de la entidad Scrim (CU3) .

Clases: ScrimBuilder.

Adapter: Utilizado para conectar nuestra interfaz INotifier con servicios externos simulados (PushService, JavaMail, DiscordService).

Clases: EmailNotifier, PushNotifier, DiscordNotifier.

Command: Utilizado para encapsular acciones de gestión del Scrim, como AsignarRol o SwapJugadores.

Clases: ScrimCommand, AsignarRolCommand, CommandInvoker.

4. Cómo Correr la Simulación (Demo)
El proyecto está configurado para correr una simulación completa del flujo de patrones desde la consola.

Requisitos
Java 17 (o superior).

Maven (para compilar y correr tests).

Pasos para Ejecutar
Clonar el repositorio.

(Opcional) Correr los tests unitarios con mvn test.

Ejecutar la clase principal main.App.java.

Esto lanzará el ConsoleController y ejecutará el método demo(), mostrando en la terminal el flujo completo de creación de Scrim, postulación de jugadores y la coreografía de patrones (State, Observer, Factory, etc.) en acción.
