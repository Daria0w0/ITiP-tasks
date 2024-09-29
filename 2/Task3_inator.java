import java.util.Scanner;

public class Task3_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ФИО: ");
        String fullName = scanner.nextLine();

        System.out.println("Результат: " + getInitials(fullName));
    }

    public static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");
        StringBuilder result = new StringBuilder();

        //Инициалы
        for (int i = 1; i < parts.length; i++) {
            result.append(parts[i].charAt(0)).append(".");
        }

        //Фамилия
        result.append(parts[0]);

        return result.toString();
    }
}