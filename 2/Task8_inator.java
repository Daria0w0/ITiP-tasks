import java.util.Scanner;

public class Task8_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Строка: ");
        String input = scanner.nextLine();
        System.out.print("Маркерный символ: ");
        char marker = scanner.next().charAt(0);
        System.out.println("Результат: " + localReverse(input, marker));
    }

    public static String localReverse(String input, char marker) {
        StringBuilder result = new StringBuilder();
        String[] parts = input.split(String.valueOf(marker));
        
        for (int i = 0; i < parts.length; i++) {
            result.append(parts[i]); // Добавляем текущую часть
            if (i < parts.length - 1) { // Если это не последняя часть
                result.append(marker); // Добавляем маркерный символ
                // Разворачиваем следующую часть
                result.append(new StringBuilder(parts[i + 1]).reverse());
                i++; // Пропускаем следующую часть, так как она уже обработана
            }
        }
        return result.toString();
    }
}