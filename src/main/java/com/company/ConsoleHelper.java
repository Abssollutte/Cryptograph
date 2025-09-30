package com.company;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

@UtilityClass
public class ConsoleHelper {
    private final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public String readString() {
        return console.readLine();
    }

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public Path buildFileName(String path, String suffix) {
        Path fullPath = Path.of(path);
        Path parent = fullPath.getParent();
        String fileName = fullPath.getFileName().toString();
        String newFileName = "";
        int index = fileName.indexOf('.');
        if (fileName.contains(".")) {
            newFileName = fileName.substring(0, index) + suffix + fileName.substring(index);
        }
        else {
            newFileName = fileName + suffix;
        }
        return parent.resolve(newFileName);
    }

}
