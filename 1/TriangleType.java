/*4.	Создайте функцию, которая принимает 3 числа: X, Y и Z. 
Эти числа представляют длины сторон треугольника. 
Функция должна вернуть тип треугольника на основе данных сторон: 
"равносторонний" (если все стороны равны), "равнобедренный" (если две стороны равны), 
"разносторонний" (если все стороны разные) или "не является треугольником" 
(если невозможно построить треугольник с заданными сторонами). */

import java.util.Scanner;

public class TriangleType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Длина стороны X: ");
        int x = scanner.nextInt();
        System.out.print("Длина стороны Y: ");
        int y = scanner.nextInt();
        System.out.print("Длина стороны Z: ");
        int z = scanner.nextInt();

        String type = triangleType(x, y, z);

        System.out.println("Тип треугольника: " + type);
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "не является треугольником";
        } else if (x == y && y == z) {
            return "равносторонний";
        } else if (x == y || y == z || x == z) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }
    }
}