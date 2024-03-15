# Sockets

A collection of Java socket programming examples for various use cases, including factorials, message sending, handling accounts, and supporting multiple clients.

## Overview

This repository includes four main packages demonstrating different aspects of socket programming in Java:

1. **Factorial Calculation**: Demonstrates a simple client-server application where the client sends a number to the server, and the server returns the factorial of that number.
2. **Message Sending**: Shows a basic example of sending a string message from the client to the server, and the server responds back.
3. **Handling Accounts**: Illustrates sending a serializable Java object (a user account) from the server to the client.
4. **Multi-Clients**: Demonstrates handling multiple clients in a server by using threads, allowing simultaneous processing of client requests.

## Getting Started

To run any of these examples, you need to have Java installed on your machine. Each main class can be executed separately to start the server or the client side of the application.

### Prerequisites

- Java Development Kit (JDK) installed.
- Basic understanding of client-server architecture.
- Knowledge of Java sockets and threading for the multi-client example.

### Running the Examples

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/Sockets.git
    ```

2. Navigate to the desired package, for example:
    ```bash
    cd Sockets/src/ma/fstm/ilisi/sockets/factoriel
    ```

3. **Compile the server and client classes**:
    ```bash
    javac *.java
    ```

4. Run the server application first:
    ```bash
    java Server
    ```

5. Open another terminal window and run the client application: 
    ```bash
    java Client
    ```

Follow similar steps to run other examples in the repository.

### Factorial Calculation
**Package**: `ma.fstm.ilisi.sockets.factoriel`\
**Classes**: `Client`, `Server`

The client sends an integer to the server, which calculates the factorial of the number and sends the result back to the client.

### Message Sending
**Package**: `ma.fstm.ilisi.sockets.message`\
**Classes**: `Client`, `Server`

The client sends a string message to the server. The server receives this message, prints it, and responds with a confirmation message.

### Handling Accounts
**Package**: `ma.fstm.ilisi.sockets.compte`\
**Classes**: `Client`, `Server`, `Compte`

Demonstrates the serialization and deserialization of a Java object (Compte) over sockets. The server sends a serialized Compte object to the client, which deserializes and prints the account details.

### Multi-Clients
**Package**: `ma.fstm.ilisi.sockets.multiclients`\
**Classes**: `Client`, `Server`

Illustrates a server that can handle multiple clients simultaneously by spawning a new thread for each client connection.

## Contributing
Feel free to fork this repository and submit pull requests to contribute to these examples. 
