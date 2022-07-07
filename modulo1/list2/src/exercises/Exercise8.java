package exercises;

import java.util.Scanner;

public class Exercise8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[5][4];
        int average = 0;
        for (int i=0; i<matriz.length; i++){
           for (int j=0; j<matriz[i].length; j++){
               if (j == 0) {
                   System.out.print("Digite o número da matricula: ");
                   matriz[i][j] = sc.nextInt();
                   sc.nextLine();
               } else if (j == 1){
                   System.out.print("Digite a média das provas: ");
                   matriz[i][j] = sc.nextInt();
                   sc.nextLine();
               } else if (j == 2){
                   System.out.print("Digite a média dos trabalhos: ");
                   matriz[i][j] = sc.nextInt();
                   sc.nextLine();
               } else if (j == 3){
                   matriz[i][j] = (int) Math.round((matriz[i][1] * 0.6) + (matriz[i][2] * 0.4));
               }
               average += matriz[i][3];
           }
        }
        average /= matriz.length;
        int highestFinalGrade = 0;
        for (int i=0; i<matriz.length; i++){
            for (int j=0; j<matriz[i].length; j++) {
                if (matriz[i][3] > highestFinalGrade){
                    highestFinalGrade = matriz[i][3];
                }
            }
        }
        int registration = 0;
        for (int i=0; i<matriz.length; i++){
            for (int j=0; j<matriz[i].length; j++) {
                if (highestFinalGrade == matriz[i][3]){
                    registration = matriz[i][0];
                }
            }
        }
        System.out.println("Matricula com maior média: " + registration);
        System.out.println("Média das notas finais: " + average);
    }
}
