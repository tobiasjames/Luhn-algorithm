import java.util.Scanner;

public class validate {
    public static void main(String[] args) {

        //input credit card number
        Scanner input = new Scanner(System.in);
        System.out.print("input credit card number: ");
        String creditCard = input.next();

        //call luhn method
        boolean review = luhn(creditCard);
        if (review == true) {
            System.out.print("this card is valid");
        }
        else {
            System.out.print("this card is invalid");
        }
    }

    public static boolean luhn(String card) {
        int total = 0;
        int x;

        //loop thru each digit
        for (int i = 0; i < card.length(); i++) {
            x = Integer.parseInt(card.substring(i, i + 1));

            //perform luhn algorithm
            if (i % 2 == 0) {
                x *= 2;
                while (x >= 10) {
                    x = (x / 10) + (x % 10);
                }
                total += x;
            }
            else {
                total += x;
            }

        }

        //determine if valid based off of luhn algorithm, string length and preamble requirements
        boolean v = true;
        int first = Integer.parseInt(card.substring(0,1));
        if (card.length() < 13 || card.length() > 16 ){
            v = false;
        } else if ((first != 4) && (first != 5) && (first != 6) && (Integer.parseInt(card.substring(0,2)) != 37)) {
            v = false;
        } else {
            v = (total % 10 == 0) ? true : false;
        }
        return v;
    }
}