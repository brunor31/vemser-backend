package exercises;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vect = new int[20];
        System.out.println("Digite 20 valores inteiros: ");
        for (int i=0; i<vect.length; i++){
            System.out.print((i+1) + "º número: ");
            vect[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i=19; i>=0; i--){
            System.out.println(vect[i]);
        }
        sc.close();
    }
}
