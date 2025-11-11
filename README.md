# 🕹️ TPO Final - eScrims: Plataforma de eSports

**Trabajo Práctico Final** — Materia: *Proceso de Desarrollo de Software*  
**Universidad:** UADE - Facultad de Ingeniería y Ciencias Exactas  

---

## 👥 Información del Grupo

**Docente:** Ruiz Matías  
**Grupo 6:**
- Acuña Laura (1177259)
- Alves Juan (1142620)
- Bossio Manuel (1191114)
- Cuenca Marcos (1185654)
- Molina Lautaro (1174643)
- Nieva Rodrigo (1108233)

---

## 🎯 1. Propósito del Proyecto

El objetivo de este TPO es **diseñar y desarrollar (ADOO)** el backend de una plataforma para organizar *scrims* (partidas amistosas) de eSports.

El sistema gestiona el **ciclo de vida completo de una partida**, desde su creación y emparejamiento hasta su finalización y notificación a los jugadores, aplicando los principios **SOLID** y los **patrones de diseño** vistos en la materia.

---

## 🏗️ 2. Arquitectura

El código fuente cumple con la **arquitectura de 4 capas** solicitada en la consigna:

| Capa | Descripción | Ejemplo |
|------|--------------|----------|
| **Controller** | Simulado por `main.controller.ConsoleController`. Actúa como la *View* o *App móvil*, según lo validado con el docente. | `ConsoleController.java` |
| **Service** | Contiene la lógica de negocio y coordinación. | `main.service.ScrimService` |
| **Domain** | Núcleo del sistema: entidades (`Scrim`, `Usuario`) y patrones de dominio (*State*, *Strategy*, etc.). | `main.domain.*` |
| **Infra** | Representa los servicios externos. Incluye notificaciones y adaptadores. | `main.infra.*` |
| **Persistencia** | Simulada con `main.repo.InMemoryScrimRepo` (no requiere BBDD real). | `InMemoryScrimRepo.java` |
| **Notificaciones** | Contiene los *Adapters* y *Factories* para los notificadores. | `main.infra.notificacion.*` |

---

## 🧩 3. Patrones de Diseño Implementados

El proyecto implementa **7 patrones de diseño** —los 4 obligatorios y 3 opcionales—.

### 🧱 Patrones Obligatorios

| Patrón | Descripción | Clases principales |
|--------|--------------|--------------------|
| **State** | Gestiona el ciclo de vida completo del `Scrim` (CUs 4–9). | `ScrimState`, `ScrimContext`, `StateBuscando`, `StateLobbyArmado`, `StateConfirmado`, `StateEnJuego`, `StateFinalizado`, `StateCancelado` |
| **Strategy** | Define algoritmos intercambiables de emparejamiento (CU5). | `MatchmakingStrategy`, `ByMMRStrategy`, `ByLatencyStrategy`, `ByHistoryStrategy` |
| **Observer** | Notifica cambios de estado (CU10) de forma desacoplada. | `DomainEventBus`, `Subscriber`, `ScrimStateChanged` |
| **Abstract Factory** | Crea familias de notificadores (simulados vs. reales) sin acoplar el Controller. | `NotifierFactory`, `DevNotifierFactory`, `ProdNotifierFactory` |

### ⚙️ Patrones Opcionales

| Patrón | Descripción | Clases principales |
|--------|--------------|--------------------|
| **Builder** | Creación compleja de la entidad `Scrim` (CU3). | `ScrimBuilder` |
| **Adapter** | Conecta la interfaz `INotifier` con servicios externos simulados (Push, Mail, Discord). | `EmailNotifier`, `PushNotifier`, `DiscordNotifier` |
| **Command** | Encapsula acciones de gestión del Scrim (ej. `AsignarRol`, `SwapJugadores`). | `ScrimCommand`, `AsignarRolCommand`, `CommandInvoker` |

---

## 🧪 4. Cómo Correr la Simulación (Demo)

El proyecto está configurado para **correr una simulación completa del flujo de patrones** desde la consola.

### 🔧 Requisitos
- Java 17 (o superior)  
- Maven (para compilar y ejecutar tests)

### ▶️ Pasos para Ejecutar

```bash
# 1. Clonar el repositorio
git clone https://github.com/<tu-usuario>/TPO-eScrims.git
cd TPO-eScrims

# 2. (Opcional) Ejecutar los tests unitarios
mvn test

# 3. Compilar y ejecutar la simulación
mvn compile
mvn exec:java -Dexec.mainClass="main.App"´´´

