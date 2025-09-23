import java.io.*;
import java.util.Scanner;

public class Decrypted {
    public static void decrypted() throws IOException {
        System.out.println("Введите путь к файлу для его расшифровки");
        Scanner console = new Scanner(System.in);
        String src = console.nextLine();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(console.nextLine());
        System.out.println("Введите адрес куда записать результат");
        String dst = console.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst));) {
            while (reader.ready()) {
                CaesarCipher caesarCipher = new CaesarCipher();
                String string = caesarCipher.decrypt(reader.readLine(), key);
                writer.write(string);
                writer.newLine();

            }
        }
    }
}
