package com.company;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.company.ConsoleHelper.*;

public class Bruteforce {

    @SneakyThrows
    public static void force() {
        writeMessage("Введите путь к файлу до расшифровки");
        String src = readString();
        Path dst = buildFileName(src, "_bruteforce");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            CaesarCipher caesar = new CaesarCipher();
            for (int i = 0; i < caesar.alphabetLength(); i++) {
                String decrypt = caesar.decrypt(builder.toString(), i);
                if (isValid(decrypt)) {
                    writer.write(decrypt);
                    writeMessage("Файл расшифрован, ключ расшифровки = " + i);
                    break;
                }

            }
        }
    }

    private static boolean isValid(String text) {
        for (String word : text.split(" ")) {
            if (word.length() > 28) return false;
        }

        List<String> list = List.of("? ", "! ", ". ", ", ", ": ", "; ");
//        boolean match = list.stream().anyMatch(str -> text.contains(str));
        boolean isValid = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValid = true;
        }
        writeMessage(text.length() > 100 ? text.substring(0, 100) : text);
        while (isValid) {
            writeMessage("Понятен ли вам этот текст [y/n]");
            String answer = readString();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            }
            else if (answer.equalsIgnoreCase("n")) {
                isValid = false;
            }
            else {
                writeMessage("Ответ должен быть либо 'y' либо 'n'");
            }
        }

        return isValid;
    }

}
