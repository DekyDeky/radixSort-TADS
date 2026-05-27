package radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Radix {

    private int[] numberArray;
    private int maxVal = 0;
    private int exp = 1;
    List<List<Integer>> radixArr;

    public Radix(int[] numberArray) {
        this.numberArray = numberArray;
        this.maxVal = numberArray.length;
        this.radixArr = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            radixArr.add(new ArrayList<>());
        }
    }

    public void SortRadix(){

        long inicio = System.nanoTime();
        int intervalo = Math.max(1, this.maxVal / 10);

        List<Long> amostras = new ArrayList<>();

        while ((this.maxVal / exp) > 0){

            for (int numero : numberArray){
                int radixIDX = (numero / exp) % 10;
                radixArr.get(radixIDX).add(numero);
            }

            int radixIDX = 0;
            for(List<Integer> recipiente : radixArr){
                for (int numero : recipiente){
                    this.numberArray[radixIDX++] = numero;
                }

                recipiente.clear();
            }

            exp *= 10;

        }

    }

    public void printArr(){
        for(int numero : numberArray){
            System.out.println(numero);
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int[] getNumberArray() {
        return numberArray;
    }

    public void setNumberArray(int[] numberArray) {
        this.numberArray = numberArray;
    }
}
