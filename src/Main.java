import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int thWidth, thHeight, fWidth, rawNumber, columnNumber;

        thWidth = scanner.nextInt();
        thHeight = scanner.nextInt();
        fWidth = scanner.nextInt();

        if (thWidth < 0 || thHeight < 0 || fWidth < 0) {
            System.out.println("Enter valid number");
        } else {
            if (thWidth % fWidth == 0) {
                rawNumber = thWidth / fWidth;
            } else {
                rawNumber = (thWidth / fWidth) + 1;
            }

            if (thHeight % fWidth == 0) {
                columnNumber = thHeight / fWidth;
            } else {
                columnNumber = (thHeight / fWidth) + 1;
            }

            System.out.println("Number of flagstones = " + rawNumber * columnNumber);
        }

        System.out.println("------------------------------------------------------------");

        for (int row = 0; row <= 6; row++) {
            for (int column = 6; column >= row; column--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------------------");


        for (int i = 1; i <= 6; i++) {
            for (int space = 1; space <= 6 - i; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= i; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}