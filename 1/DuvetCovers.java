/* 
6.	У меня есть ограниченное количество ткани определенной длины, 
и я хочу сшить как можно больше пододеяльников. Создайте функцию, 
которая будет принимать длину ткани (в метрах) и размер одной детали (ширина и длина в метрах), 
а затем возвращать количество пододеяльников, которые я смогу сшить, прежде чем кончится рулон. 

n * 2 – это количество квадратных метров имеющейся ткани,
w и h – это длина и ширина одной детали в метрах

Примечание:
- Не считайте пододеяльник, если на него не хватило ткани в рулоне */


import java.util.Scanner;

public class DuvetCovers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Длина ткани в метрах: ");
        int n = scanner.nextInt();
        System.out.print("Ширина одной детали в метрах: ");
        double w = scanner.nextDouble();
        System.out.print("Длина одной детали в метрах: ");
        double h = scanner.nextDouble();

        int count = howManyItems(n, w, h);

        System.out.println("Количество пододеяльников: " + count);
    }

    public static int howManyItems(int n, double w, double h) {
        double availableFabric = n * 2; // Количество квадратных метров ткани
        double itemSize = w * h; // Площадь одной детали
        return (int) (availableFabric / itemSize); // Количество пододеяльников
    }
}