// Server program
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SiriServer {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Siri Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String question;
            while ((question = in.readLine()) != null) {
                String decryptedQuestion = VigenereCipher.decrypt(question);
                System.out.println("Received (encrypted): " + question);
                System.out.println("Decrypted Question: " + decryptedQuestion);

                String answer = switch (decryptedQuestion.toLowerCase()) {
                    case "who created you?" -> "I was created by Apple.";
                    case "what does siri mean?" -> "Victory and beautiful.";
                    case "are you a robot?" -> "I am a virtual assistant.";
                    default -> "I don't know the answer to that.";
                };

                String encryptedAnswer = VigenereCipher.encrypt(answer);
                out.println(encryptedAnswer);
                System.out.println("Sent (encrypted): " + encryptedAnswer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}