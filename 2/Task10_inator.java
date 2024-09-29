import java.util.Scanner;
import java.util.Arrays;

public class Task10_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Первая строка: ");
        String str1 = scanner.nextLine();

        System.out.print("Вторая строка: ");
        String str2 = scanner.nextLine();

        boolean isAnagram = isAnagram(str1, str2);
        System.out.println("Являются ли строки анаграммами? " + isAnagram);
    }

    public static boolean isAnagram(String str1, String str2) {
    // Удаляет пробелы и приводит к нижнему регистру
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();
        
        // Сравнивает отсортированные строки
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}