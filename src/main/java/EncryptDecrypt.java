import java.io.*;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void crypt(boolean flag) throws IOException {
        System.out.println("Введите путь к файлу для его " + (flag ? "шифровки" : "расшифровки"));
        Scanner console = new Scanner(System.in);
        String src = console.nextLine();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(console.nextLine());
        System.out.println("Введите адрес куда записать результат");
        String dst = console.nextLine();
        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst));) {
            while (reader.ready()) {
                String string = reader.readLine();
                String result = flag ? caesar.encrypt(string, key) : caesar.decrypt(string, key);
                writer.write(result);
                writer.newLine();
            }
        }
    }
}