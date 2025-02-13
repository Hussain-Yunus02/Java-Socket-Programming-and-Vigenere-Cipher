// Client program
import java.io.*;
import java.net.*;

public class SiriClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to Siri Server.");

            String question;
            while (true) {
                System.out.print("You: ");
                question = userInput.readLine();
                if (question.equalsIgnoreCase("exit")) break;

                String encryptedQuestion = VigenereCipher.encrypt(question);
                out.println(encryptedQuestion);
                System.out.println("Sent (encrypted): " + encryptedQuestion);

                String encryptedAnswer = in.readLine();
                String answer = VigenereCipher.decrypt(encryptedAnswer);
                System.out.println("Siri (decrypted): " + answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}