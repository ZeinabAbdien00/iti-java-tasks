import java.sql.Time;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {

        System.out.println(reverse(-123456));
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        System.out.println(longestWord("big flower"));
        System.out.println(longestWord("this is a house"));
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        SimpleTime obj = new SimpleTime(12 , 0 , 0 , 0);
        System.out.println(obj.toSecondOfDay());

        SimpleTime obj1 = new SimpleTime(6, 30);
        System.out.println(obj1.toNanoOfDay());

        SimpleTime obj2 = new SimpleTime(1);
        System.out.println(obj2.toNanoOfDay());

        SimpleTime obj3 = new SimpleTime(1f);
        System.out.println(obj3.toNanoOfDay());



    }

    static int reverse(int number) {
        Boolean isNegative = false;
        if (number < 0) {
            number = number * -1;
            isNegative = true;
        }

        int reverse = 0;
        int remainder;
        while (number > 0) {
            remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number = number / 10;
        }
        if (isNegative)
            return reverse * -1;
        else
            return reverse;

    }

    static String longestWord(String word) {
        String[] words = word.split(" ");
        String longest = words[0];
        for (String s : words) {
            if (s.length() > longest.length())
                longest = s;
        }
        return longest;
    }
}