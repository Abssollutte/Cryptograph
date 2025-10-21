package com.company;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptDecrypt {
    @SneakyThrows
    public static void encrypt(boolean flag) {
        System.out.println("Введите путь к файлу для его " + (flag ? "шифровки" : "расшифровки"));
        String src = ConsoleHelper.readString();
        System.out.println("Введите ключ");
        int key = ConsoleHelper.readInt();
        Path dst = ConsoleHelper.buildFileName(src, (flag ? "_encrypt" : "_decrypt"));
        CaesarCipher caesar = new CaesarCipher();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {
            while (reader.ready()) {
                String string = reader.readLine();
                String result = flag ? caesar.encrypt(string, key) : caesar.decrypt(string, key);
                writer.write(result);
                writer.newLine();
            }
        }
    }
}