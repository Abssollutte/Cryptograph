package com.company;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        while (true) {
            ConsoleHelper.writeMessage("""
                    Выберите действие введя его номер
                    1. Зашифровать текст в файле с помощью ключа
                    2. Расщифровать текст в файле с помощью ключа
                    3. Подобрать ключ к зашифрованному тексту в файле (BruteForce)
                    4. Расшифровать текст в файле с помощью синтаксического анализа текста
                    5. Выход их программы""");
            Scanner console = new Scanner(System.in);
            String answer = console.nextLine();

            switch (answer) {
                case ("1") -> EncryptDecrypt.encrypt(true);
                case ("2") -> EncryptDecrypt.encrypt(false);
                case ("3") -> System.out.println("action3");
                case ("4") -> System.out.println("action4");
                case ("5") -> {return;}
            }
        }

    }
}