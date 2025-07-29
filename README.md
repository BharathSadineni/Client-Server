# Client-Server

A secure client-server Java application with authentication functionality for user login. Includes a streamlined data pipeline to efficiently manage incoming and outgoing data.

## Features

- **User Authentication:** Secure login with username and password validation.
- **Client-Server Communication:** Reliable socket-based communication.
- **Data Pipeline:** Efficient parsing and handling of data exchanged between client and server.
- **Scalable Design:** Easily extendable to add more features or support more clients.

## Project Structure

- `Server.java` – Main server application, handles multiple clients and authentication.
- `Client.java` – Client application with login prompt and communication logic.
- `User.java` – Manages user information and authentication logic.
- Utilities for data parsing or protocol handling.

## How It Works

1. Start the server (`Server.java`), which waits for client connections.
2. Client (`Client.java`) connects and submits login details.
3. Server validates credentials (could be hardcoded or loaded from a file).
4. Upon successful login, client can send/receive data through the established connection.

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/BharathSadineni/Client-Server.git
   cd Client-Server
   ```

2. **Compile the code**
   ```bash
   javac *.java
   ```

3. **Run the server**
   ```bash
   java Server
   ```

4. **Run the client (in a new terminal)**
   ```bash
   java Client
   ```

## Requirements

- Java 8 or higher

## Customization

- Add more commands or features to the protocol in `Server.java` and `Client.java`.
- Update user authentication logic in `User.java` or integrate with a database.

---
