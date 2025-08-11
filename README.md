# Airport Hexagonal

This is a small application to try different software architectures. This application is written in a hexagonal architecture.

## Architecture

This application consists of a core and adapters. The idea is that the core interacts with the adapters through the ports. The adapters allow easy exchange of technology while having the business logic isolated in the core.

The domain model is shared between core and adapters.

### Core

Contains the Business logic and use cases. Uses output-ports to interact with outgoing adapters (e.g. data access) and input-ports for ingoing adapters (e.g. presentation).

#### Input Ports

Expose interfaces for ingoing adapters to access the application logic of the core.
In this app we expose use case interfaces in order for the presentation adapter to interact with the business logic.

#### Output Ports

Define interfaces needed by the core that should be implemented inside the outgoing adapters.
In this app we define repository interfaces needed by the business logic that the data access adapter will implement.

### Adapters

#### Presentation Adapter (Ingoing)

Contains the View objects that the user interacts with. Calls the business logic through the input ports. 

#### Data Access In-Memory Adapter (Outgoing)

Contains the implementation of the repositories to store and access the data. Implements and provides the output ports. 
