import java.util.Scanner;

public class Task6_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Строка в формате CamelCase: ");
        String camelCase = scanner.nextLine();

        String snakeCase = camelToSnake(camelCase);
        System.out.println("Строка в формате SnakeCase: " + snakeCase);
    }

    public static String camelToSnake(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c) && result.length() > 0) {
                result.append('_');
            }

            result.append(Character.toLowerCase(c));
        }

        return result.toString();
    }
}    
