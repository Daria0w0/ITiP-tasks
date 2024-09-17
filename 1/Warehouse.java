/* 3.	В этой задаче вы управляете складом, где хранятся товары трех типов:

- Коробки содержат по 20 товаров в каждой.
- Мешки содержат по 50 товаров в каждом.
- Бочки содержат по 100 товаров в каждой.

Вам предоставили информацию о количестве каждого типа емкостей на складе, 
и вам нужно создать функцию, которая вернет общее количество товаров на складе, 
учитывая объекты хранения разных типов */


import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество коробок: ");
        int boxes = scanner.nextInt();
        System.out.print("Количество мешков: ");
        int bags = scanner.nextInt();
        System.out.print("Количество бочек: ");
        int barrels = scanner.nextInt();

        int totalItems = containers(boxes, bags, barrels);

        System.out.println("Общее количество товаров: " + totalItems);
    }

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }
}