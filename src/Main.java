
import java.util.Scanner;

class xaxa {
    private static final String[] WORDS = {"apple", "banana", "cherry", "durian", "elderberry","abandon","able","aboard","abundant"};
    private static final int MAX_TRIES = 6;

    private String word;
    private int remainingTries;
    private boolean[] guessed;

    public xaxa() {
        word = WORDS[(int) (Math.random() * WORDS.length)];
        remainingTries = MAX_TRIES;
        guessed = new boolean[word.length()];
    }

    private boolean isGameWon() {
        for (boolean b : guessed) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void printWord() {
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                System.out.print(word.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (remainingTries > 0 && !isGameWon()) {
            System.out.println("Remaining tries: " + remainingTries);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine();
            char guess = input.charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed[i] = true;
                    found = true;
                }
            }

            if (!found) {
                remainingTries--;
                System.out.println("Wrong guess!");
            }

            printWord();
        }

        scanner.close();

        if (isGameWon()) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Game over! The word was " + word);
        }
    }

    public static void main(String[] args) {
        xaxa game = new xaxa();
        game.play();
    }
}