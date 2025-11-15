package com.company;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.company.ConsoleHelper.*;

public class Parsing {
    @SneakyThrows
    public static void parse() {
        writeMessage("Введите путь к файлу для его расшифровки");
        String src = readString();
        writeMessage("Введите путь к файлу для набора статистики");
        String stats = readString();
        Path parsed = buildFileName(src, "_parsed");
        Map<Character, Integer> mapSrc = fillMap(src);
        Map<Character, Integer> mapStats = fillMap(stats);
        List<Map.Entry<Character, Integer>> listSrc = mapToList(mapSrc);
        List<Map.Entry<Character, Integer>> listStats = mapToList(mapStats);
        Map<Character, Character> mapDecrypt = new HashMap<>();
        if (listSrc.size() <= listStats.size()) {
            for (int i = 0; i < listSrc.size(); i++) {
                mapDecrypt.put(listSrc.get(i).getKey(), listStats.get(i).getKey());
            }
            try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
                 BufferedWriter writer = Files.newBufferedWriter(parsed)) {
                while (reader.ready()) {
                    String string = reader.readLine();
                    char[] charArray = string.toCharArray();
                    StringBuilder builder = new StringBuilder();
                    for (char aChar : charArray) {
                        Character character = mapDecrypt.get(aChar);
                        builder.append(character);
                    }
                    writer.write(builder.toString());
                    writer.newLine();
                }
            }
            writeMessage("Содержимое файла расшифровано методом синтаксического анализа.");
        } else {
            writeMessage("Размер файла статистики не достатотчен для расшифровки.");
        }

    }

    @SneakyThrows
    private static Map<Character, Integer> fillMap(String path) {
        Map<Character, Integer> result = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            while (reader.ready()) {
                String string = reader.readLine();
                for (char character : string.toCharArray()) {
                    if (!result.containsKey(character)) {
                        result.put(character, 1);
                    } else {
                        result.put(character, result.get(character) + 1);
                    }

//                    result.merge(character, 1, Integer::sum);
                }
            }
        }
        return result;
    }

    private static List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

//        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());
        return list;
    }


}
