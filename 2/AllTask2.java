import java.util.Arrays;

public class AllTask2 {
    public static void main(String[] args) {
        // Задание 1
        String task1Str1 = "Barack";
        String task1Str2 = "Obama";
        System.out.println("Task 1: " + duplicateChars(task1Str1, task1Str2)); // "rck"

        // Задание 2
        int[] task2Numbers = {3, 12, 7, 81, 52};
        System.out.println("Task 2: " + dividedByThree(task2Numbers)); // 2

        // Задание 3
        String task3FullName1 = "Simonov Sergei Evgenievich";
        System.out.println("Task 3: " + getInitials(task3FullName1)); // "S.E.Simonov"

        // Задание 4
        double[] task4Numbers1 = {3.5, 7.0, 1.5, 9.0, 5.5};
        double[] task4Result1 = normalizator(task4Numbers1);
        System.out.println("Task 4: " + Arrays.toString(task4Result1)); // [0.3333, 0.8333, 0.0, 1.0, 0.6667]

        double[] task4Numbers2 = {10.0, 10.0, 10.0, 10.0};
        double[] task4Result2 = normalizator(task4Numbers2);
        System.out.println("Task 4: " + Arrays.toString(task4Result2)); // [0.0, 0.0, 0.0, 0.0]

        // Задание 5
        double[] task5Numbers = {1.6, 0, 212.3, 34.8, 0, 27.5};
        int[] task5Result = compressedNums(task5Numbers); 
        System.out.println("Task 5: " + Arrays.toString(task5Result)); // [1, 27, 34, 212]

        // Задание 6
        String task6CamelCase = "helloWorld";
        System.out.println("Task 6: " + camelToSnake(task6CamelCase)); // "hello_world"

        // Задание 7
        int[] task7Numbers = {3, 5, 8, 1, 2, 4};
        System.out.println("Task 7: " + secondBiggest(task7Numbers)); // 5

        // Задание 8
        String input = "Hello, I’m under the water, please help me";
        String mark = "e";
        char marker = mark.charAt(0);
        System.out.println("Task 8: " + localReverse(input, marker)); // " Hednu m’I ,oller thetaw er, plesae hem ple"

        // Задание 9
        System.out.println("Task 9: " + equal(8, 1, 8)); // 2
        System.out.println("Task 9: " + equal(5, 5, 5)); // 3
        System.out.println("Task 9: " + equal(4, 9, 6)); // 0

        // Задание 10
        System.out.println("Task 10: " + isAnagram("LISTEN", "silent")); // true
        System.out.println("Task 10: " + isAnagram("Eleven plus two?", "Twelve plus one!")); // true
        System.out.println("Task 10: " + isAnagram("hello", "world")); // false
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

    public static int dividedByThree(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0 && num % 3 == 0) {
                count++;
            }
        }

        return count;
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

    public static double[] normalizator(double[] numbers) {
        double min = numbers[0];
        double max = numbers[0];

        for (double num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double[] normalized = new double[numbers.length];

        if (min == max) {
            for (int i = 0; i < numbers.length; i++) {
                normalized[i] = 0;  //Если все элементы одинаковые
            }
        } else {
            // Нормализуем каждый элемент
            for (int i = 0; i < numbers.length; i++) {
                normalized[i] = (numbers[i] - min) / (max - min);
            }
        }

        return normalized;
    }

    public static int[] compressedNums(double[] numbers) {
        return Arrays.stream(numbers)
                     .filter(num -> num != 0)
                     .distinct()
                     .sorted()
                     .mapToInt(num -> (int) num)
                     .toArray();
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

    public static int secondBiggest(int[] numbers) {
        int[] copy = numbers.clone();
        Arrays.sort(copy);
        return copy[copy.length - 2];
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

    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        }
        return 0;
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



