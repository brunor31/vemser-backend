package aula2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /*
        int[] vect = new int[3];
        vect[0] = 10;
        vect[1] = 15;
        vect[2] = 20;
        int sum = vect[0] + vect [1] + vect [2];
        int average = (vect[0] + vect [1] + vect [2]) / vect.length;
        System.out.println("Soma: " + sum);
        System.out.println("Média: " + average);

        int[][] matriz = new int[2][2];

        matriz[0][0] = 10;
        matriz[0][1] = 15;
        matriz[1][0] = 20;
        matriz[1][1] = 25;

        int sumLine1 = 0;
        for (int i=0; i<matriz.length; i++){
            sumLine1 += matriz[0][i];
        }
        int sumLine2 = 0;
        for (int i=0; i<matriz.length; i++){
            sumLine2 += matriz[1][i];
        }
        System.out.println("Linha 1: " + sumLine1);
        System.out.println("Linha 2: " + sumLine2);
        System.out.println("Linha 1 - linha 2: " + (sumLine1 - sumLine2));

        int sumLine1 =  matriz[0][0] +  matriz[0][1];
        int sumLine2 = matriz[1][0] + matriz[1][1];
        System.out.println("Linha 1: " + sumLine1);
        System.out.println("Linha 2: " + sumLine2);
        System.out.println("Linha 1 - linha 2: " + (sumLine1 - sumLine2));

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de elementos do vetor: ");
        int n = sc.nextInt();
        int[] vect = new int[n];
        int sum = 0;
        for (int i=0; i< vect.length; i++){
            System.out.print("Digite o valor da posição " + i + " do vetor: ");
            vect[i] = sc.nextInt();
            sum += vect[i];
        }
        double average = (double) sum / vect.length;
        System.out.println("A média dos elementos do vetor é: " + average);
        sc.close();

         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String word = sc.next().toLowerCase();
        while(!word.equals("fim")){
            System.out.println("Você digitou: " + word);
            System.out.print("Digite uma palavra: ");
            word = sc.next().toLowerCase();
        }
        sc.close();

    }
}
