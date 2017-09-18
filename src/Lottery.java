import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {

        int lottery = ((int)(Math.random()*999));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three digit lottery pick");
        int guess = input.nextInt();

        int lotteryDigit1 = lottery / 100;
        int lotteryDigit2 = (lottery / 10) - (lotteryDigit1 * 10);
        int lotteryDigit3 = lottery % 10;


        int guessDigit1 = guess / 100;
        int guessDigit2 = (guess / 10) - (guessDigit1 * 10);
        int guessDigit3 = guess % 10;


        List<Integer> lotteryList = Arrays.asList(lotteryDigit1, lotteryDigit2, lotteryDigit3);
        List<Integer> guessList = Arrays.asList(guessDigit1, guessDigit2, guessDigit3);

        List<Integer> guessList1 = Arrays.asList(guessDigit1, guessDigit2);
        List<Integer> guessList2 = Arrays.asList(guessDigit1, guessDigit3);
        List<Integer> guessList3 = Arrays.asList(guessDigit2, guessDigit3);

        boolean containsOne = Collections.disjoint(lotteryList, guessList);


        System.out.println("The lottery number is " + lottery);

        if (guess == lottery)
            System.out.println("you win $10,000");
        else if (lotteryList.containsAll(guessList) && guessList.containsAll(lotteryList))
            System.out.println("You win $5,000");
        else if (lotteryList.containsAll(guessList1) && guessList1.containsAll(guessList2) || lotteryList.containsAll(guessList2) || lotteryList.containsAll(guessList3))
            System.out.println("You win $2,000");
        else if(!containsOne)
            System.out.println("You win $1,000");
        else
            System.out.println("Sorry you lose");
    }
}
