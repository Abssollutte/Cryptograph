import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие введя его номер");
            System.out.println("1. Зашифровать текст в файле с помощью ключа");
            System.out.println("2. Расщифровать текст в файле с помощью ключа");
            System.out.println("3. Подобрать ключ к зашифрованному тексту в файле (BruteForce)");
            System.out.println("4. Расшифровать текст в файле с помощью синтаксического анализа текста");
            System.out.println("5. Выход их программы");
            Scanner console = new Scanner(System.in);
            String answer = console.nextLine();

            switch (answer) {
                case ("1") -> System.out.println("action1");
                case ("2") -> System.out.println("action2");
                case ("3") -> System.out.println("action3");
                case ("4") -> System.out.println("action4");
                case ("5") -> {return;}
            }
        }

    }
}