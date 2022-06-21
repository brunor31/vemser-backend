package exercises;

import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int count = 0;
        for (int i=0; i<matriz.length; i++){
            for (int j=0;j<matriz[i].length;j++){
                System.out.printf("Digite o número da linha %d e coluna %d: ", i, j);
                matriz[i][j] = sc.nextInt();
                if (matriz[i][j] > 10){
                    count++;
                }
            }
        }
        System.out.println("A matriz possui " + count + " valores maiores do que 10");
    }
}
