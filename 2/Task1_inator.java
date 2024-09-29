import java.util.Scanner;

public class Task1_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Первая строка: ");
        String str1 = scanner.nextLine();

        System.out.print("Вторая строка: ");
        String str2 = scanner.nextLine();

        System.out.println("Результат: " + duplicateChars(str1, str2));
    }

    public static String duplicateChars(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        // Перебираем символы первой строки
        for (char c : str1.toCharArray()) {
            // Если символ не входит во вторую строку, добавляем его к результату
            if (str2.indexOf(c) == -1) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}