import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllTasks3 {
    public static void main(String[] args) {
        System.out.println("Task 1: " + isStrangePair("ratio", "orator"));      //Task 1
        System.out.println("Task 1: " + isStrangePair("sparkling", "groups"));
        System.out.println("Task 1: " + isStrangePair("bush", "hubris"));
        System.out.println("Task 1: " + isStrangePair("", ""));

        System.out.println("");
        List<Object[]> items = new ArrayList<>();         //Task 2
        items.add(new Object[]{"Laptop", 124200});
        items.add(new Object[]{"Phone", 51450});
        items.add(new Object[]{"Headphones", 13800});

        List<Object[]> discountedItems = sale(items, 25);
        System.out.println("Task 2");
        for (Object[] item : discountedItems) {
            System.out.println(item[0] + ": " + item[1]);
        }
        
        System.out.println("");
        System.out.println("Task 3: " + successShoot(0, 0, 5, 2, 2));    //Task 3
        System.out.println("Task 3: " + successShoot(-2, -3, 4, 5, -6));

        System.out.println("");
        System.out.println("Task 4: " + parityAnalysis(243));     //Task 4
        System.out.println("Task 4: " + parityAnalysis(12));
        System.out.println("Task 4: " + parityAnalysis(3));

        System.out.println("");
        System.out.println("Task 5: " + rps("rock", "paper"));
        System.out.println("Task 5: " + rps("paper", "rock"));
        System.out.println("Task 5: " + rps("paper", "scissors"));
        System.out.println("Task 5: " + rps("scissors", "scissors"));
        System.out.println("Task 5: " + rps("scissors", "paper"));

        System.out.println("");
        System.out.println("Task 6: " + burger(39));
        System.out.println("Task 6: " + burger(999));
        System.out.println("Task 6: " + burger(4));

        System.out.println("");                       //Task 7
        List<Object[]> inventory = List.of(
            new Object[]{"Скакалка", 550, 8},
            new Object[]{"Шлем", 3750, 4},
            new Object[]{"Мяч", 2900, 10}
        );
        System.out.println("Task 7: " + mostExpensive(inventory));

        System.out.println("");                      //Task 8
        System.out.println("Task 8: " + longestUnique("abcba"));
        System.out.println("Task 8: " + longestUnique("bbb"));

        System.out.println("");                       //Task 9
        System.out.println("Task 9: " + isPrefix("automation", "auto-"));
        System.out.println("Task 9: " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("Task 9: " + isPrefix("retrospect", "sub-"));
        System.out.println("Task 9: " + isSuffix("vocation", "-logy"));

        System.out.println("");                          //Task 10
        System.out.println("Task 10: " + doesBrickFit(1, 1, 1, 1, 1));
        System.out.println("Task 10: " + doesBrickFit(1, 2, 1, 1, 1));
        System.out.println("Task 10: " + doesBrickFit(1, 2, 2, 1, 1)); 
    }   
    
    public static boolean isStrangePair(String str1, String str2) {   //Task 1
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        } else if (str1.isEmpty() && !str2.isEmpty() || !str1.isEmpty() && str2.isEmpty()) {
            return false;
        } else return str1.charAt(0) == str2.charAt(str2.length() - 1) && str2.charAt(0) == str1.charAt(str1.length() - 1);
    }

    public static List<Object[]> sale(List<Object[]> items, int discount){    //Task 2
        List<Object[]> discountedItems = new ArrayList<>();
        for (Object[] item : items) {
            String name = (String) item[0];
            int price = (int) item[1];
            int discountedPrice = Math.max(1, (int) Math.round(price * (1 - discount / 100.0)));
            discountedItems.add(new Object[]{name, discountedPrice});
        }
        return discountedItems;
    }

    public static boolean successShoot(int x, int y, int r, int m, int n) {    //Task 3
        //По Th Пифагора
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - 2, 2));
        return distance <= r;
    }

    public static boolean parityAnalysis(int a) {      //Task 4
        int sum = 0;
        int num = a;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return (a % 2 == sum % 2);
    }

    public static String rps(String p1, String p2) {       // Task 5
        if (p1 == p2) {
            return "Tie";
        }
        if ((p1 == "rock" && p2 == "scissors") || (p1 == "scissors" && p2 == "paper")
                || (p1 == "paper" && p2 == "rock")) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }

    public static int burger(int a) {       //Task 6
        int count = 0;
        while (a >= 10) {
            int product = 1;
            while (a > 0) {
                product *= a % 10;
                a /= 10;
            }
            a = product;
            count++;
        }
        return count;
    }

    public static String mostExpensive(List<Object[]> inventory) {      //Task 7
        String mostExpensiveItem = "";
        int maxCost = 0;
        for (Object[] item : inventory) {
            String name = (String) item[0];
            int price = (int) item[1];
            int quantity = (int) item[2];
            int totalCost = price * quantity;
            if (totalCost > maxCost) {
                maxCost = totalCost;
                mostExpensiveItem = name;
            } 
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxCost;
    }

    public static String longestUnique(String str) {        //Task 8
        String longest = "";
        StringBuilder temp = new StringBuilder();
        HashSet<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            temp.setLength(0); 
            uniqueChars.clear(); 

            for (int j = i; j < str.length(); j++) {
                char currentChar = str.charAt(j);
                if (uniqueChars.add(currentChar)) { 
                    temp.append(currentChar); 
                    if (temp.length() > longest.length()) {
                        longest = temp.toString(); 
                    }
                } else {
                    break;
                }
            }
        }
        return longest;
    }

    public static boolean isPrefix(String word, String prefix) {            //Task 9
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {     //Task 10
        return (a <= w && b <= h) || (a <= h && b <= w) || 
        (b <= w && c <= h) || (b <= h && c <= w) ||
        (a <= w && c <= h) || (a <= h && c <= w);
    }
}