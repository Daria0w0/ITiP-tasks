/* 9.	Создайте функцию, которая принимает количество билетов на концерт, 
проданных через веб-сервис, и стоимость одного билета с учетом фиксированной комиссии. 
Функция должна вернуть общую выручку от продажи билетов. */

import java.util.Scanner;

public class TicketSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество проданных билетов: ");
        int tickets = scanner.nextInt();
        System.out.print("Стоимость одного билета: ");
        int price = scanner.nextInt();

        int revenue = ticketSaler(tickets, price);

        System.out.println("Общая выручка: " + revenue);
    }

    public static int ticketSaler(int tickets, int price) {
        double commissionRate = 0.08; // Фиксированная комиссия 8%
        return (int) (tickets * price * (1 - commissionRate));
    }
}