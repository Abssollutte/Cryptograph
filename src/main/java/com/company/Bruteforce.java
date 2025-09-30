package com.company;

import lombok.SneakyThrows;

import java.nio.file.Path;

import static com.company.ConsoleHelper.*;

public class Bruteforce {
    @SneakyThrows
    public static void force() {
        writeMessage("Введите путь к файлу до расшифровки");
        String src = readString();
        Path dst = buildFileName(src, "_bruteforce");
        
    }
}
