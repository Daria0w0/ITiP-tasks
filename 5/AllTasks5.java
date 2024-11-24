import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllTasks5 {
    public static void main(String[] args) {
        System.out.println("Task 1: " + sameLetterPattern("ABAB", "CDCD"));
        System.out.println("Task 1: " + sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println("Task 1: " + sameLetterPattern("FFGG", "CDCD"));
        System.out.println("Task 1: " + sameLetterPattern("FFFF", "ABCD"));
    
        System.out.println("");
        System.out.println("Task 2: " + memeSum(26, 39));
        System.out.println("Task 2: " + memeSum(122, 81));

        System.out.println("");
        System.out.println("Task 3: " + digitsCount(4666));
        System.out.println("Task 3: " + digitsCount(544));
        System.out.println("Task 3: " + digitsCount(121317));
        System.out.println("Task 3: " + digitsCount(0));
        System.out.println("Task 3: " + digitsCount(12345));
        System.out.println("Task 3: " + digitsCount(1289396387328L));

        System.out.println("");
        System.out.println("Task 4: " + totalPoints(new String[]{"cat", "create", "sat"}, "caster")); 
        System.out.println("Task 4: " + totalPoints(new String[]{"trance", "recant"}, "recant")); 
        System.out.println("Task 4: " + totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println("");
        System.out.println("Task 5: " + longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println("Task 5: " + longestRun(new int[]{1, 2, 3, 10, 11, 15}));
        System.out.println("Task 5: " + longestRun(new int[]{5, 4, 2, 1}));
        System.out.println("Task 5: " + longestRun(new int[]{3, 5, 7, 10, 15}));

        System.out.println("");
        System.out.println("Task 6: " + takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println("Task 6: " + takeDownAverage(new String[]{"10%"}));
        System.out.println("Task 6: " + takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println("");
        System.out.println("Task 7: " + canMove("Rook", "A8", "H8"));
        System.out.println("Task 7: " + canMove("Bishop", "A7", "G1"));
        System.out.println("Task 7: " + canMove("Queen", "C4", "D6"));

        System.out.println("");
        System.out.println("Task 8: " + maxPossible(9328, 456));
        System.out.println("Task 8: " + maxPossible(523, 76));
        System.out.println("Task 8: " + maxPossible(9132, 5564));
        System.out.println("Task 8: " + maxPossible(8732, 91255));

        System.out.println("");
        System.out.println("Task 9: " + timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); 
        System.out.println("Task 9: " + timeDifference("London", "July 31, 1983 23:01", "Rome")); 
        System.out.println("Task 9: " + timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("");
        System.out.println("Task 10: " + isNew(3));
        System.out.println("Task 10: " + isNew(30));
        System.out.println("Task 10: " + isNew(321));
        System.out.println("Task 10: " + isNew(123));
    }

    public static List<Integer> positions(String str, char a) {                 //Task1 
        List<Integer> symbols = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                symbols.add(i);
            }
        }
        return symbols;
     }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (!positions(str1, currentChar).equals(positions(str2, str2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }


    public static int memeSum(int a, int b) {                         //Task 2
        StringBuilder result = new StringBuilder();
        while (a > 0 || b > 0) {
            result.insert(0, (a % 10 + b % 10));
            a /= 10;
            b /= 10;
        }
        return Integer.parseInt(result.toString());
    }

    public static int digitsCount(long number) {                     //Task 3
        if (number == 0) {
            return 1;
        }
        return countDigits(number);
    }

    private static int countDigits(long number) {
        if (number == 0) {
            return 0;
        }
        return countDigits(number / 10) + 1;
    }

    public static int totalPoints(String[] words, String decryptedString) { // Task 4 
        int points = 0; 
        ArrayList<Character> decryptedCharacters = new ArrayList<>(); 
    
        for (int index = 0; index < decryptedString.length(); index++) { 
            decryptedCharacters.add(decryptedString.charAt(index)); 
        } 
    
        for (String word : words) { 
            ArrayList<Character> currentWordCharacters = new ArrayList<>(); 
            for (char letter : word.toCharArray()) 
                currentWordCharacters.add(letter); 
            for (char letter : decryptedCharacters) 
                currentWordCharacters.remove((Character) letter); 
            if (!currentWordCharacters.isEmpty()) 
                continue; 
    
            switch (word.length()) {
                case 3 -> points += 1;
                case 4 -> points += 2;
                case 5 -> points += 3;
                case 6 -> points += 54;
                default -> {
                }
            }
        } 
    
        return points; 
    }

    public static int longestRun(int[] arr) {                        //Task 5                   
        if (arr.length == 0) return 0;
        int maxRun = 1;
        int ongoingRun = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1] - 1) {
                ongoingRun++;
            } else {
                maxRun = Math.max(maxRun, ongoingRun);
                ongoingRun = 1;
            }
        }
        return Math.max(maxRun, ongoingRun);
    }

    public static String takeDownAverage(String[] list) {                     //Task 6
        double total = 0;
        for (String a : list) {
            total += Double.parseDouble(a.replace("%", ""));
        }
        double average = (total / list.length) - 5; 
        double x = average * (list.length + 1) - total;

        return (int)x + "%";
    }

    public static boolean canMove(String figure, String start, String end) {         //Task 7
        int startX = start.charAt(0) - 'A';
        int startY = Character.getNumericValue(start.charAt(1)) - 1;
        int endX = end.charAt(0) - 'A';
        int endY = Character.getNumericValue(end.charAt(1)) - 1;

        if (figure.equalsIgnoreCase("pawn")) {
            return (startX == endX && endY == startY + 1);
        }
        if (figure.equalsIgnoreCase("knight")) {
            return (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2) || 
            (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1);
        }
        if (figure.equalsIgnoreCase("bishop")) {
            return (Math.abs(startX - endX) == Math.abs(startY - endY));
        }
        if (figure.equalsIgnoreCase("rook")) {
            return (startX == endX || startY == endY);
        }
        if (figure.equalsIgnoreCase("queen")) {
            return (startX == endX || startY == endY || 
            Math.abs(startX - endX) == Math.abs(startY - endY));
        }
        if (figure.equalsIgnoreCase("king")) {
            return (Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1);
        }
        
        return false;
    }

    public static int maxPossible(int num1, int num2) {                               //Task 8
        char[] num1Digits = String.valueOf(num1).toCharArray();
        char[] num2Digits = String.valueOf(num2).toCharArray();
        Arrays.sort(num2Digits);
        reverse(num2Digits);
        int j = 0;
        for (int i = 0; i < num1Digits.length; i++) {
            if (j < num2Digits.length && num1Digits[i] < num2Digits[j]) {
                num1Digits[i] = num2Digits[j++];
            }
        }

        return Integer.parseInt(new String(num1Digits));
    }

    private static void reverse(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static String timeDifference(String cityA, String timeA, String cityB) {         //Task 9
        HashMap<String, Double> gmt = new HashMap<>();
        gmt.put("Los Angeles", -8.0);
        gmt.put("New York", -5.0);
        gmt.put("Caracas", -4.5);
        gmt.put("Buenos Aires", -3.0);
        gmt.put("London", 0.0);
        gmt.put("Rome", 1.0);
        gmt.put("Moscow", 3.0);
        gmt.put("Tehran", 3.5);
        gmt.put("New Delhi", 5.5);
        gmt.put("Beijing", 8.0);
        gmt.put("Canberra", 10.0);

        String[] timeParts = timeA.replace(",", "").split("\\s+");
        String inMonth = timeParts[0];
        int inDay = Integer.parseInt(timeParts[1]);
        int inYear = Integer.parseInt(timeParts[2]);
        String[] timeSplit = timeParts[3].split(":");
        int inHours = Integer.parseInt(timeSplit[0]);
        int inMinutes = Integer.parseInt(timeSplit[1]);

        double gmtA = gmt.get(cityA);
        double gmtB = gmt.get(cityB);
        double diff = gmtB - gmtA;

        int totalMinutes = (inHours * 60 + inMinutes) + (int) (diff * 60);
        int outHours = (totalMinutes / 60) % 24;
        int outMinutes = totalMinutes % 60;
        int outDays = totalMinutes / (60 * 24);
        
        inDay += outDays;
        int outMonth = getMonthIndex(inMonth); 
        while (inDay > daysInMonths(outMonth, inYear)) {
            inDay -= daysInMonths(outMonth, inYear);
            outMonth = (outMonth + 1) % 12; 
            if (outMonth == 0) inYear++; 
        }

        return String.format("%d-%02d-%02d %02d:%02d", inYear, outMonth + 1, inDay, outHours, outMinutes);
    }

    private static int getMonthIndex(String month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            if (month.equals(months[i])) {
                return i; 
            }
        }
        return -1; 
    }

    private static int daysInMonths(int month, int year) {
        if (month == 1) { // Февраль
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28; 
        }
        return new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[month];
    }


    public static boolean isNew(int number) {                       //Task 10
        if (number == 0) {
            return true;
        }
        String numStr = String.valueOf(number);
        char[] digits = numStr.toCharArray();
        Arrays.sort(digits);
        String sortedNum = new String(digits);
        for (int i = 0; i < number; i++) {
            if (String.valueOf(i).equals(sortedNum)) {
                return false;
            }
        }
        return true;
    }
}
