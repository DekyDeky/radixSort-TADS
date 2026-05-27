package radix;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("Inicializando Arrays...");
        long startTime = System.nanoTime();

        Setup setup = new Setup();
        Radix cSort = new Radix(setup.getNumbersC());
        Radix cMilSort = new Radix(setup.getNumbersCMil());
        Radix cMSort = new Radix(setup.getNumbersCM());

        long endTime = System.nanoTime();
        long durationInNanos = endTime - startTime;
        long durationInMillis = durationInNanos / 1_000_000;

        getTime(durationInMillis, "Array inicializado em: ");


        Scanner entrada = new Scanner(System.in);

        int pagina = 1;
        int opcao;

        while(true){

            menu();
            opcao = entrada.nextInt();

            if(opcao == 0)
                break;

            switch(opcao) {
                case 1:
                    System.out.println("Ordenando números de 1 a 100...");
                    startTime = System.nanoTime();
                    cSort.SortRadix();
                    endTime = System.nanoTime();
                    durationInNanos = endTime - startTime;
                    durationInMillis = durationInNanos / 1_000_000;

                    getTime(durationInMillis, "Array Organizado em: ");

                    break;
                case 2:
                    System.out.println("Ordenando números de 1 a 10.000...");
                    startTime = System.nanoTime();
                    cMilSort.SortRadix();
                    endTime = System.nanoTime();
                    durationInNanos = endTime - startTime;
                    durationInMillis = durationInNanos / 1_000_000;

                    getTime(durationInMillis, "Array Organizado em: ");
                    break;
                case 3:
                    System.out.println("Ordenando números de 1 a 100.000...");
                    startTime = System.nanoTime();
                    cMSort.SortRadix();
                    endTime = System.nanoTime();
                    durationInNanos = endTime - startTime;
                    durationInMillis = durationInNanos / 1_000_000;

                    getTime(durationInMillis, "Array Organizado em: ");
                    break;
                case 4:
                    System.out.println("Exibindo lista de 1 a 100...");
                    cSort.printArr();
                    break;
                case 5:
                    System.out.println("Exibindo lista de 1 a 10.000...");
                    cMilSort.printArr();
                    break;
                case 6:
                    System.out.println("Exibindo lista de 1 a 100.000...");
                    cMSort.printArr();
                    break;
                case 7:
                    System.out.println("Bagunçando listas...");
                    System.out.println("Bagunçando lista de 1 a 100...");
                    resetSort(cSort, true);
                    System.out.println("Lista de 1 a 100 bagunçada!");
                    System.out.println("Bagunçando listas de 1 a 10.000");
                    resetSort(cMilSort, true);
                    System.out.println("Lista de 1 a 10.000 bagunçada!");
                    System.out.println("Bagunçando listas de 1 a 100.000");
                    resetSort(cMSort, true);
                    System.out.println("Lista de 1 a 100.000 bagunçada!");
                    break;
                case 8:
                    System.out.println("Iniciando todos os testes com as seguintes listas nas seguintes ordens:");
                    System.out.println("1. Números de 1 a 100;");
                    System.out.println("2. Números de 1 a 10.000;");
                    System.out.println("3. Números de 1 a 100.000;");

                    Radix[] sorts = {cSort, cMilSort, cMSort};



                    for(Radix sort : sorts){

                        long[] tempos = new long[10];
                        System.out.println("Começando mais um ciclo de testes...");
                        resetSort(sort, false);

                        for(int i = 0; i < 10; i++){
                            startTime = System.nanoTime();
                            sort.SortRadix();
                            durationInMillis = (System.nanoTime() - startTime) / 1_000_000;
                            tempos[i] = durationInMillis;
                            System.out.println("Milisegundos: " + durationInMillis);
                            System.out.println("Segundos: " + (float)durationInMillis / 1000);
                            //getTime(durationInMillis, "Array Organizado em: ");
                            if(i == 9){
                                continue;
                            }
                            resetSort(sort, false);
                        }

                        long valorTotal = 0;

                        for(long valor : tempos){
                            valorTotal += valor;
                        }

                        System.out.println("Média do ciclo: " + (valorTotal / 10));
                    }
                    break;
                default:
                    System.out.println("Selecione uma opção válida...");
                    entrada.nextLine();
                    break;
            }




        }


    }

    private static void getTime(long duracaoMillis, String mensagem){
        String textoDuracao = "";

        if(duracaoMillis > 1000){
            float segundos = (float)duracaoMillis / 1000;
            textoDuracao = segundos + " segundos.";
        }else {
            textoDuracao = duracaoMillis + " milisegundos.";
        }

        System.out.println(mensagem + textoDuracao);
    }

    private static void resetSort(Radix sort, boolean getTime){

        long startTime = getTime ? System.nanoTime() : 0;

        sort.setNumberArray(Setup.shuffleArray(sort.getNumberArray()));
        sort.setExp(1);

        if(getTime){
            long durationInMillis = (System.nanoTime() - startTime) / 1_000_000;
            getTime(durationInMillis, "Array Organizado em: ");
        }
    }

    private static void menu(){
        System.out.println("------------------ Radix Sort ------------------");
        System.out.println("1 - Ordenar a menor lista.");
        System.out.println("2 - Ordenar a lista média.");
        System.out.println("3 - Ordenar a maior lista");
        System.out.println("4 - Exibir a menor lista.");
        System.out.println("5 - Exibir a lista média.");
        System.out.println("6 - Exibir a maior lista.");
        System.out.println("7 - Desorganizar listas...");
        System.out.println("8 - Realizar Teste Final.");
        System.out.println("0 - para sair.");
        System.out.println("Digite sua opção: ");
    }



}
