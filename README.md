# Java Socket Programming and Vigenere Cipher

Here’s a well-structured **README.md** file for your GitHub repository based on Lab 1. It provides a professional and educational overview of the lab while making it engaging.

---

# **COE817 - Lab 1: Java Socket Programming & Vigenère Cipher**

## **Overview**
This lab introduces **Java Socket Programming** by implementing a **client-server chat system** that simulates a basic Siri-style text assistant. The project demonstrates:
- **Single-client communication** with a server
- **Multi-client communication** using threading
- **Secure message exchange** using **Vigenère Cipher encryption & decryption**

---
## **Key Concepts**
- **Java Sockets (`java.net` package)**
- **Client-Server Architecture**
- **Multi-threading for handling multiple clients**
- **Vigenère Cipher for encrypted communication**
- **TCP/IP Networking Basics**

---
## **Lab Objectives**
- Gain hands-on experience with **Java socket programming**.
- Implement a **Siri text chat system** where clients send questions, and the server responds.
- Encrypt and decrypt messages using **Vigenère Cipher** with the key `"TMU"`.
- Extend the server to **handle multiple clients concurrently**.

---
## **Project 1: Single-Client Siri Chat System**
### **Description**
This project implements a **basic client-server chat system**, where:
1. The **client sends encrypted questions** to the server.
2. The **server decrypts and processes the question**.
3. The **server responds with an encrypted answer**.
4. The **client decrypts and displays the response**.

### **Implementation Steps**
1. **Setup the server (`SiriServer.java`)** to listen for client requests.
2. **Setup the client (`SiriClient.java`)** to connect and send questions.
3. Implement **Vigenère Cipher encryption** for outgoing messages.
4. Implement **Vigenère Cipher decryption** for incoming messages.

### **Sample Chat Flow**
**Client (Encrypted Message):**  
```
Encrypted(Q: Who created you?) → Server
```
**Server (Decryption & Response):**  
```
Decrypted: "Who created you?"  
Response: "I was created by Apple."
Encrypted(A: I was created by Apple.) → Client
```
**Client (Decryption & Display):**  
```
Decrypted Answer: "I was created by Apple."
```

---
## **Project 2: Multi-Client Siri Chat System**
### **Description**
This project extends **Project 1** to support **multiple clients simultaneously**. The server **spawns a new thread** for each connected client.

### **Implementation Steps**
1. Modify `SiriServer.java` to **accept multiple connections**.
2. Use **multi-threading** (`Thread` class) to handle concurrent clients.
3. Implement **synchronized message handling** to ensure secure communication.

### **Expected Behavior**
- Multiple clients can chat with the Siri server at the same time.
- Each client's conversation is encrypted using **Vigenère Cipher**.
- The server manages multiple encrypted conversations separately.

---
## **Encryption: Vigenère Cipher**
To secure communication, this lab uses **Vigenère Cipher** with the encryption key **"TMU"**.

### **Encryption Formula**
Each letter in the plaintext is shifted based on the corresponding letter in the repeating key:
```
Ciphertext = (Plaintext + Key) % 26
```
### **Decryption Formula**
```
Plaintext = (Ciphertext - Key) % 26
```
### **Example**
| Plaintext | H | E | L | L | O |
|-----------|---|---|---|---|---|
| Key (TMU) | T | M | U | T | M |
| Ciphertext | ? | ? | ? | ? | ? |

---
## **Setup & Execution**
### **Prerequisites**
- Java 8+ installed
- NetBeans or any Java IDE
- Basic understanding of **networking and cryptography**

---
## **Demonstration & Expected Output**
For **Project 1**, the program will display:
- **Encrypted question sent from the client**
- **Decrypted question displayed by the server**
- **Encrypted response from the server**
- **Decrypted answer displayed by the client**

For **Project 2**, the program will:
- Show **multiple clients connected** to the server.
- Handle **multiple encrypted conversations** in parallel.

---
## **Enhancements & Future Work**
- **Improve Encryption**: Use **AES** instead of Vigenère for stronger security.
- **GUI Implementation**: Create a **graphical interface** for a better chat experience.
- **Logging Feature**: Store conversations for future analysis.
- **Natural Language Processing (NLP)**: Improve Siri’s responses dynamically.

---
## **References**
- [Java Socket Programming Guide](https://docs.oracle.com/javase/tutorial/networking/sockets/)
- [Vigenère Cipher Explanation](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)

---


## **Author**
**Husain Yunus Maudiwala**  
*5th-year Computer Engineering Student @ Toronto Metropolitan University*  
