package radix;

import java.util.Random;

public class Setup {

    private final int sizeC = 100_000_000;
    private int[] numbersC = new int[sizeC];

    private final int sizeCMil = 10_000;
    private int[] numbersCMil = new int[sizeCMil];

    private final int sizeCM = 100_000;
    private int[] numbersCM = new int[sizeCM];

    public Setup() {

        initializeArray(numbersC);
        shuffleArray(numbersC);

        initializeArray(numbersCMil);
        shuffleArray(numbersCMil);

        initializeArray(numbersCM);
        shuffleArray(numbersCM);

    }

    private void initializeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static int[] shuffleArray(int[] array) {
        Random rand = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = rand.nextInt(i + 1);

            // Swap array[i] with the element at random index j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    public int[] getNumbersC() {
        return numbersC;
    }

    public int[] getNumbersCMil() {
        return numbersCMil;
    }

    public int[] getNumbersCM() {
        return numbersCM;
    }
}
