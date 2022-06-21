package exercises;

import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        int[][] matriz = {
                {10, 15, 17, 9},
                {16,9,8,7},
                {1,25,50,5},
                {2,13,29,30}
        };
        int count = 0;
        for (int i=0; i<matriz.length; i++){
            for (int j=0;j<matriz[i].length;j++){
                if (matriz[i][j] > 10){
                    count++;
                }
            }
        }
        System.out.println("A matriz possui " + count + " valores maiores do que 10");
    }
}
